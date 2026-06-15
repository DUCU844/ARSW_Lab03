package classroomManagement;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * This is the HTTP server for classrooms.
 * It listens on port 8081.
 *
 * Supported routes:
 *
 *   GET  /rooms              -> list all classrooms
 *   GET  /rooms?id=E303      -> check status of one classroom
 *   POST /rooms/reserve?id=E303  -> reserve a classroom
 *   POST /rooms/release?id=E303  -> release a classroom
 *
 * You can test with a browser (only GET), curl, or Postman.
 *
 * curl examples:
 *   curl http://localhost:8081/rooms
 *   curl http://localhost:8081/rooms?id=E303
 *   curl -X POST http://localhost:8081/rooms/reserve?id=E301
 *   curl -X POST http://localhost:8081/rooms/release?id=E301
 */
public class ClassroomHttpServer {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8081), 0);
        ClassroomRepository repository = new ClassroomRepository();

        server.createContext("/rooms", new ClassroomHandler(repository));
        server.setExecutor(null);
        server.start();

        System.out.println("ClassroomHttpServer running at http://localhost:8081/rooms");
    }

    /**
     * This handler runs every time someone sends a request to /rooms or any sub-path.
     * It checks the HTTP method (GET or POST) and the path to decide what to do.
     */
    static class ClassroomHandler implements HttpHandler {

        private ClassroomRepository repository;

        /**
         * Create the handler with the repository it needs.
         *
         * @param repository the object that holds all classrooms in memory
         */
        public ClassroomHandler(ClassroomRepository repository) {
            this.repository = repository;
        }

        /**
         * Handle the HTTP request.
         * Check the method and path, then call the correct operation.
         *
         * @param exchange the object that holds the request and the response
         */
        @Override
        public void handle(HttpExchange exchange) {
            try {
                String method = exchange.getRequestMethod();
                String path   = exchange.getRequestURI().getPath();
                String query  = exchange.getRequestURI().getQuery();

                String response;

                if (method.equals("GET") && path.equals("/rooms") && query == null) {
                    response = handleListAll();

                } else if (method.equals("GET") && path.equals("/rooms") && query != null) {
                    response = handleConsult(query);

                } else if (method.equals("POST") && path.equals("/rooms/reserve")) {
                    response = handleReserve(query);

                } else if (method.equals("POST") && path.equals("/rooms/release")) {
                    response = handleRelease(query);

                } else {
                    response = "ERROR: route not found. Check the URL and the HTTP method.";
                }

                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * List all classrooms and their current status.
         * Returns a simple text with one classroom per line.
         *
         * @return a text with all classrooms
         */
        private String handleListAll() {
            StringBuilder sb = new StringBuilder();
            sb.append("=== All Classrooms ===\n");
            for (Classroom c : repository.findAll()) {
                String status = c.getAvailable() ? "AVAILABLE" : "RESERVED";
                sb.append(c.getClassroomId()).append(" -> ").append(status).append("\n");
            }
            return sb.toString();
        }

        /**
         * Check the status of one classroom.
         * The query string must have the id, for example: id=E303
         *
         * @param query the query string from the URL
         * @return SALON_DISPONIBLE, SALON_RESERVADO, or an error message
         */
        private String handleConsult(String query) {
            String classroomId = extractId(query);
            if (classroomId == null) {
                return "ERROR: use ?id=E303";
            }

            Classroom classroom = repository.findByClassroomId(classroomId);
            if (classroom == null) {
                return "ERROR_SALON_NO_EXISTE";
            }

            return classroom.getAvailable() ? "SALON_DISPONIBLE" : "SALON_RESERVADO";
        }

        /**
         * Reserve a classroom.
         * The query string must have the id, for example: id=E303
         *
         * @param query the query string from the URL
         * @return RESERVA_EXITOSA, ERROR_OPERACION_INVALIDA, or an error message
         */
        private String handleReserve(String query) {
            String classroomId = extractId(query);
            if (classroomId == null) {
                return "ERROR: use ?id=E303";
            }

            Classroom classroom = repository.findByClassroomId(classroomId);
            if (classroom == null) {
                return "ERROR_SALON_NO_EXISTE";
            }
            if (!classroom.getAvailable()) {
                return "ERROR_OPERACION_INVALIDA";
            }

            repository.reserveClassroom(classroom);
            return "RESERVA_EXITOSA";
        }

        /**
         * Release a classroom so other people can use it.
         * The query string must have the id, for example: id=E303
         *
         * @param query the query string from the URL
         * @return LIBERACION_EXITOSA, ERROR_OPERACION_INVALIDA, or an error message
         */
        private String handleRelease(String query) {
            String classroomId = extractId(query);
            if (classroomId == null) {
                return "ERROR: use ?id=E303";
            }

            Classroom classroom = repository.findByClassroomId(classroomId);
            if (classroom == null) {
                return "ERROR_SALON_NO_EXISTE";
            }
            if (classroom.getAvailable()) {
                return "ERROR_OPERACION_INVALIDA";
            }

            repository.releaseClassroom(classroom);
            return "LIBERACION_EXITOSA";
        }

        /**
         * Read the classroom ID from the query string.
         * The query string looks like: id=E303
         * If it is wrong or missing, we return null.
         *
         * @param query the query string from the URL
         * @return the classroom ID as text, or null if not valid
         */
        private String extractId(String query) {
            if (query == null || !query.startsWith("id=")) {
                return null;
            }
            return query.substring(3).trim();
        }
    }
}
