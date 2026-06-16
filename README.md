# ARSW Lab 03 - Distributed Architectures with Java

This lab shows how the same system can be built using different communication styles.
Each part solves a problem that the previous part left open.

---

## Part I - TCP Sockets

### Guide Example: Movie TCP Server

A basic client-server system that uses raw TCP sockets.
The client sends a text message and the server responds with text.

**Protocol:**
```
Client sends:   MOVIE:1
Server responds: 1,Interstellar,Christopher Nolan,2014
```

**How to run:**
```bash
cd movie-tcp/src/main/java
javac movies/*.java
java movies.MovieServer
# In another terminal:
java movies.MovieClient
```

---

### Exercise 1: Classroom Management via TCP

A TCP server that manages classroom reservations for the school.
The system keeps 4 classrooms in memory: E301, E302, E303, E304.

#### How it works

The client sends a message with this format:
```
OPERATION,CLASSROOM_ID
```

The server reads the message, splits it by comma, and runs the correct operation.

#### Protocol

| Client sends | Server responds |
|---|---|
| `CONSULTAR_SALON,E303` | `SALON_DISPONIBLE` or `SALON_RESERVADO` |
| `RESERVAR_SALON,E303` | `RESERVA_EXITOSA` or `ERROR_OPERACION_INVALIDA` |
| `LIBERAR_SALON,E303` | `LIBERACION_EXITOSA` or `ERROR_OPERACION_INVALIDA` |
| Any operation with bad ID | `ERROR_SALON_NO_EXISTE` |

#### Architecture

```
ClassroomClient
      |
      | TCP message: "RESERVAR_SALON,E303"
      v
ClassroomServer (port 12345)
      |
      | processRequest() splits by comma
      | switch(operation) calls the right handler
      v
ClassroomRepository (data in memory)
      |
      | changes available field and saves
      v
ClassroomServer sends response back to client
```

#### Initial data

| Classroom | Available |
|---|---|
| E301 | true |
| E302 | false |
| E303 | false |
| E304 | true |

#### How to run

```bash
cd movie-tcp/src/main/java
javac classroomManagement/*.java

# Terminal 1 - start server
java classroomManagement.ClassroomServer

# Terminal 2 - start client
java classroomManagement.ClassroomClient
```

The client shows a menu:
```
=== Classroom Management Client ===

Choose an operation:
1 - Check classroom status (CONSULTAR)
2 - Reserve a classroom (RESERVAR)
3 - Release a classroom (LIBERAR)
0 - Exit
Enter option:
```

#### Troubleshooting: port already in use

If you see this error when starting the server:
```
Exception in thread "main" java.net.BindException: Address already in use: bind
```

It means port 12345 is already occupied — usually because a previous server instance is still running.

**On Windows:**

Step 1 — find the process using port 12345:
```powershell
netstat -ano | findstr :12345
```
The output looks like this:
```
TCP    0.0.0.0:12345    0.0.0.0:0    LISTENING    5432
```
The last number (`5432`) is the PID of the process.

Step 2 — kill that process:
```powershell
taskkill /PID 5432 /F
```

Step 3 — start the server again:
```powershell
java classroomManagement.ClassroomServer
```

**On Linux / Mac:**

```bash
lsof -i :12345
# shows the PID
kill -9 <PID>
```

#### Key design decisions

- Each operation opens and closes its own TCP connection. This matches the server behavior, which also closes after each response.
- The loop in the client lets the user run many operations without restarting.
- `ClassroomRepository` keeps all data in a `HashMap<String, Classroom>`. The key is the classroom ID (for example `"E303"`).
- Reserve sets `available = false`. Release sets `available = true`. Neither operation deletes the classroom from the map.

---

## Reflection Questions - Part I

### 1. How easy would it be to add a new operation to the protocol?

Not very easy with this design. To add a new operation, you need to:

1. Add a new `case` in the `switch` inside `processRequest()` in `ClassroomServer`.
2. Write a new private handler method in the server.
3. Add any new method needed in `ClassroomRepository`.
4. Update the client menu with the new option.
5. Tell every developer what the new text format is, because the protocol is not written in a formal file.

The main problem is that the protocol is just a text convention. There is no file that describes what operations exist, what parameters they need, or what responses they return. If someone reads `"CONSULTAR_SALON,E303"` for the first time, they need to read the server code to understand it. This is fragile and hard to maintain.

### 2. What happens if two clients try to reserve the same classroom at the same time?

This server is **not thread-safe**. It handles one client at a time in the `while(true)` loop:

```
Client A connects → server accepts → reads message → processes → responds → closes
Client B connects → server accepts → (same sequence)
```

Because only one client runs at a time, two simultaneous reservations are not possible in this implementation. However, this also means the server **blocks** while it handles Client A. Client B must wait until Client A finishes.

If the server were changed to handle multiple clients at the same time (using threads), a race condition would appear:

```
Thread A reads classroom E301 → available = true
Thread B reads classroom E301 → available = true   (same moment)
Thread A sets available = false, saves
Thread B sets available = false, saves  (also "succeeds" — wrong!)
```

Both clients would receive `RESERVA_EXITOSA`, but only one should win. The fix would be to use `synchronized` on the `reserveClassroom` method, or use a concurrent data structure.

### 3. Where is the communication contract defined: in a formal file or in text conventions?

In this exercise, the contract **exists only as text conventions in the code**. There is no formal file.

The "contract" is scattered across:
- The `switch` cases in `ClassroomServer.processRequest()` — this defines what operations exist.
- The `if` conditions in each handler — this defines the rules.
- The string values like `"RESERVA_EXITOSA"` — these are the possible responses.
- The client menu — this shows what the user can do.

If a new developer joins the project, they must read all four classes to understand the full contract. There is no single document or file that describes the protocol completely.

This is one of the main problems with TCP text protocols. Later in this lab, gRPC solves this by using a `.proto` file as the formal contract. The `.proto` file describes every operation, every parameter, and every response in one place, and it can generate code automatically for any language.

---

## Part II - HTTP Architecture

### Guide Example: Movie HTTP Server

The TCP server only works with a Java client.
HTTP lets any browser, curl, or Postman talk to the server — no custom client needed.

**How to run:**
```bash
cd movie-tcp/src/main/java
javac movies/*.java
java movies.MovieHttpServer
```

Then open in browser: `http://localhost:8080/movie?id=1`

**What changed from TCP:**

| TCP | HTTP |
|---|---|
| `MOVIE:1` — custom text | `GET /movie?id=1` — standard format |
| Only Java clients | Any browser or tool |
| Protocol in your head | Method + path + parameters |

---

### Exercise 2: Classroom Management via HTTP

Same classroom system from Exercise 1, but now exposed via HTTP.
No Java client needed — test with browser, curl, or Postman.

#### Routes

| Method | Path | What it does |
|---|---|---|
| `GET` | `/rooms` | List all classrooms and their status |
| `GET` | `/rooms?id=E303` | Check status of one classroom |
| `POST` | `/rooms/reserve?id=E303` | Reserve a classroom |
| `POST` | `/rooms/release?id=E303` | Release a classroom |

#### Architecture

```
Browser / curl / Postman
         |
         | HTTP request: GET /rooms?id=E303
         v
ClassroomHttpServer (port 8081)
         |
         | handle() checks method + path + query
         | calls handleConsult / handleReserve / handleRelease
         v
ClassroomRepository (same as Part I, in memory)
         |
         | reads or changes available field
         v
ClassroomHttpServer writes text response back
```

#### How to run

```bash
cd movie-tcp/src/main/java
javac classroomManagement/*.java
java classroomManagement.ClassroomHttpServer
```

Then test with curl:
```bash
# List all classrooms
curl http://localhost:8081/rooms

# Check status of E303
curl http://localhost:8081/rooms?id=E303

# Reserve E301
curl -X POST http://localhost:8081/rooms/reserve?id=E301

# Release E301
curl -X POST "http://localhost:8081/rooms/release?id=E301"
```

Or open `http://localhost:8081/rooms` in a browser (GET only).

#### Troubleshooting: port already in use

Same error as Part I but for port 8081:
```
java.net.BindException: Address already in use
```

```powershell
netstat -ano | findstr :8081
taskkill /PID <PID> /F
```

---

## Reflection Questions - Part II

### 1. What advantages does HTTP offer over a manually defined text protocol?

HTTP gives structure that everyone already knows:

- **Method** (`GET`, `POST`) tells you if you are reading or changing something. In TCP, all messages looked the same — just text.
- **Path** (`/rooms`, `/rooms/reserve`) describes the resource and action clearly.
- **Standard tools work immediately.** Any browser, curl, Postman, or any language can call the server. In TCP, you needed a custom Java client.
- **Status codes** (`200`, `404`) give a standard way to say if something worked or failed.

The main gain is **interoperability**: other systems can talk to this server without knowing anything special about it.

### 2. What limitations does building an HTTP server without a framework have?

Without a framework (like Spring Boot), you do everything manually:

- **Routing is manual.** We check `path.equals("/rooms/reserve")` ourselves. With 20 routes this becomes a mess.
- **No JSON support.** We return plain text. To return proper JSON we would need to build the strings manually or add a library.
- **No input validation.** If someone sends `?id=` with nothing, we have to handle that ourselves.
- **No error handling middleware.** Each handler must catch its own exceptions.
- **No content negotiation.** We cannot easily return different formats (HTML, JSON, XML) based on what the client asks for.

This is fine for learning, but not for production systems.

### 3. How would this solution change if JSON was used instead of HTML?

The server logic stays the same. Only the response changes.

Instead of returning:
```
RESERVA_EXITOSA
```

We would return:
```json
{ "result": "RESERVA_EXITOSA", "classroomId": "E301" }
```

Changes needed:
1. Build a JSON string manually, or add a library like Gson or Jackson.
2. Add the header `Content-Type: application/json` before sending the response.
3. The client reads JSON instead of plain text — easier to parse in any language.

JSON is better for APIs because the response has structure. Any client (JavaScript, Python, mobile app) can read it easily without parsing raw text.

---

## Part III - RPC with Java RMI

### Guide Example: Movie RMI Server

RMI lets a Java client call methods on an object that lives in another JVM.
No need to design message formats — you just call a method.

```
Client calls:  service.getMovie(1)
               ↓  (goes through network)
Server runs the method and returns the Movie object
               ↓
Client receives the Movie object
```

**How to run:**
```bash
cd movie-tcp/src/main/java
javac movies/*.java

# Terminal 1
java movies.MovieRmiServer

# Terminal 2
java movies.MovieRmiClient
```

---

### Exercise 3: Lab Equipment Inventory with RMI

A system to consult and reserve laboratory equipment.
The contract is a Java interface (`LabService`) — no text protocol.

#### Initial equipment

| Code  | Name             | Lab   | Status    |
|-------|------------------|-------|-----------|
| PC-01 | Desktop Computer | Lab A | AVAILABLE |
| PC-02 | Desktop Computer | Lab A | RESERVED  |
| RP-01 | Raspberry Pi     | Lab B | AVAILABLE |
| AR-01 | Arduino Kit      | Lab B | AVAILABLE |
| LP-01 | Laptop           | Lab C | RESERVED  |

#### Remote interface

```java
List<String> consultarEquipos()
String consultarEquipo(String codigo)
boolean reservarEquipo(String codigo)
boolean liberarEquipo(String codigo)
```

#### Architecture

```
LabRmiClient
     |
     | registry.lookup("labService")  → gets remote reference
     v
RMI Registry (port 24000)
     |
     | returns stub (fake local object)
     v
LabRmiClient calls service.reservarEquipo("PC-01")
     |
     | RMI sends the call through the network automatically
     v
LabServiceImpl.reservarEquipo() runs on server
     |
     | returns boolean result
     v
Client receives true or false
```

#### How to run

```bash
cd movie-tcp/src/main/java
javac labInventory/*.java

# Terminal 1
java labInventory.LabRmiServer

# Terminal 2
java labInventory.LabRmiClient
```

#### Key design decisions

- `LabEquipment implements Serializable` — required so RMI can send the object through the network.
- `LabServiceImpl extends UnicastRemoteObject` — makes the object available for remote calls.
- Port 24000 avoids conflict with the movie RMI server on port 23000.
- The contract (`LabService` interface) is the only thing the client needs to know — not how the server stores data.

---

## Reflection Questions - Part III

### 1. What changed when moving from HTTP to RMI?

In HTTP, the client builds a URL string and reads a text response:
```
GET /rooms/reserve?id=E301  →  "RESERVA_EXITOSA"
```

In RMI, the client calls a real Java method and gets a real Java object back:
```java
boolean result = service.reservarEquipo("PC-01");  // true or false
```

The differences:
- **No protocol to design.** The Java interface IS the contract.
- **Typed results.** You get `boolean`, `List<String>`, or an object — not raw text.
- **No parsing.** You don't split strings or check text values.
- **Error handling is Java exceptions**, not error strings.

The experience feels like calling local code, even though the method runs on another machine.

### 2. Where is the communication contract defined?

In `LabService.java`. That one interface describes every operation:
- What method names exist
- What parameters each method takes (and their types)
- What each method returns (and its type)
- What exceptions can happen

Both client and server must use this interface. If the server changes a method signature, the client stops compiling. This is much stronger than the text conventions in Part I.

### 3. What problems would this system have if a client is not written in Java?

RMI only works between Java programs. It uses Java serialization to send objects through the network — a format that only Java understands.

If a Python or JavaScript client tried to connect to the RMI registry, it would fail completely. There is no standard way to read Java-serialized objects in other languages.

This is the main limitation of RMI. A system built with RMI is **locked to Java on both sides**. gRPC (Part IV) solves this: the `.proto` contract generates code for any language, so a Java server can talk to a Python client.

---

## Part IV - gRPC

### Guide Example: Movie gRPC Server

gRPC is modern RPC. The contract lives in a `.proto` file.
Maven reads that file and generates all the Java classes automatically.
The server and client only write business logic.

```
movie.proto  →  mvn compile  →  generated classes
                                      ↓
                           MovieGrpcServer uses them
                           MovieGrpcClient uses them
```

**How to run:**
```bash
cd movie-grpc
mvn clean compile
mvn exec:java -Dexec.mainClass="edu.eci.arsw.movie.MovieGrpcServer"

# In another terminal:
mvn exec:java -Dexec.mainClass="edu.eci.arsw.movie.MovieGrpcClient"
```

**Troubleshooting: port already in use (port 50051)**
```powershell
netstat -ano | findstr :50051
taskkill /PID <PID> /F
```

---

### Exercise 4: University Wellness Appointment System with gRPC

A gRPC service to manage wellness appointments for students.
Contract defined in `appointment.proto`.

#### Contract (`appointment.proto`)

```protobuf
service AppointmentService {
  rpc RequestAppointment (AppointmentRequest)  returns (AppointmentResponse);
  rpc CancelAppointment  (CancelRequest)       returns (CancelResponse);
  rpc GetAppointments    (StudentRequest)      returns (AppointmentList);
}
```

#### Business rules

- New appointment always starts with status `REQUESTED`
- `GetAppointments` returns only active (non-cancelled) appointments
- `CancelAppointment` changes status to `CANCELLED` — does not delete from memory
- Each appointment gets a random short ID generated with `UUID`

#### Architecture

```
AppointmentGrpcClient
         |
         | channel → localhost:50052
         v
AppointmentGrpcServer
         |
         | AppointmentServiceImpl (extends generated base class)
         | HashMap<String, Appointment> in memory
         v
Returns AppointmentResponse / CancelResponse / AppointmentList
```

#### How to run

```bash
cd movie-grpc
mvn clean compile

# Terminal 1
mvn exec:java -Dexec.mainClass="edu.eci.arsw.wellness.AppointmentGrpcServer"

# Terminal 2
mvn exec:java -Dexec.mainClass="edu.eci.arsw.wellness.AppointmentGrpcClient"
```

**Troubleshooting: port already in use (port 50052)**
```powershell
netstat -ano | findstr :50052
taskkill /PID <PID> /F
```

---

## Reflection Questions - Part IV

### 1. Why is the `.proto` file considered a contract?

A contract is a document that both sides (client and server) must follow.
The `.proto` file describes exactly:
- What operations exist (`rpc RequestAppointment ...`)
- What data each operation receives (`AppointmentRequest`)
- What data each operation returns (`AppointmentResponse`)
- What types each field has (`string`, `int32`, `bool`, enum)

If the server changes a field name or type in the `.proto`, the client stops compiling.
Both sides are forced to agree on the same structure.
This is much stronger than text conventions (Part I) or Java interfaces (Part III).

### 2. How easy would it be to create a client in another language?

Very easy. This is one of the biggest advantages of gRPC.

Steps for a Python client:
1. Copy the `.proto` file to the Python project
2. Run `python -m grpc_tools.protoc` to generate Python classes
3. Write the client using the generated classes — same operations, same field names

The `.proto` file is the same for every language.
A Java server on port 50052 can talk to a Python client, a Go client, a C++ client — all at the same time.
This is impossible with RMI.

### 3. What differences do you find between RMI and gRPC?

| Topic | RMI | gRPC |
|---|---|---|
| Contract | Java interface (`.java`) | Proto file (`.proto`) |
| Languages | Java only | Any language |
| Serialization | Java serialization (binary, Java-only) | Protocol Buffers (binary, universal) |
| Code generation | No (you write everything) | Yes (Maven generates classes from `.proto`) |
| Transport | Java RMI protocol | HTTP/2 |
| Performance | Slower (Java serialization overhead) | Faster (Protobuf is very compact) |
| Learning curve | Simpler to start | Requires understanding proto files |

Both use the RPC model: the client calls a method that runs on the server.
The key difference is that gRPC is language-agnostic and generates code automatically.
