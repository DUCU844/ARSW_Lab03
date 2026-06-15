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
