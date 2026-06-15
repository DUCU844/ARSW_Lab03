package classroomManagement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This is the TCP server for classrooms.
 * It listens on port 12345 and waits for client messages.
 *
 * The client sends a message with this format:
 *   OPERATION,CLASSROOM_ID
 *
 * Possible operations:
 *   CONSULTAR_SALON,E303   -> check if the classroom is available or reserved
 *   RESERVAR_SALON,E303    -> reserve the classroom
 *   LIBERAR_SALON,E303     -> release the classroom
 *
 * Possible responses:
 *   SALON_DISPONIBLE        -> classroom is free
 *   SALON_RESERVADO         -> classroom is already reserved
 *   RESERVA_EXITOSA         -> reservation was successful
 *   LIBERACION_EXITOSA      -> release was successful
 *   ERROR_SALON_NO_EXISTE   -> classroom ID not found
 *   ERROR_OPERACION_INVALIDA -> operation not allowed (e.g. reserve an already reserved room)
 */
public class ClassroomServer {

    public static void main(String[] args) throws Exception {
        ClassroomRepository repository = new ClassroomRepository();
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Classroom Server Started on port 12345...");

        while (true) {
            Socket clientSocket = serverSocket.accept();

            BufferedReader inFromClient = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter outToClient = new PrintWriter(
                    clientSocket.getOutputStream(), true);

            String request = inFromClient.readLine();
            String response = processRequest(request, repository);
            outToClient.println(response);

            inFromClient.close();
            outToClient.close();
            clientSocket.close();
        }
    }

    /**
     * Read the client message and decide what to do.
     *
     * The message must have two parts separated by a comma:
     *   parts[0] = operation  (for example "CONSULTAR_SALON")
     *   parts[1] = classroom ID  (for example "E303")
     *
     * @param request the message from the client
     * @param repository the object that holds all classrooms in memory
     * @return the response text that the server sends back to the client
     */
    private static String processRequest(String request, ClassroomRepository repository) {
        if (request == null || !request.contains(",")) {
            return "ERROR: invalid format. Use OPERATION,CLASSROOM_ID";
        }

        String[] parts = request.split(",");

        if (parts.length != 2) {
            return "ERROR: invalid format. Use OPERATION,CLASSROOM_ID";
        }

        String operation = parts[0].trim();
        String classroomId = parts[1].trim();

        Classroom classroom = repository.findByClassroomId(classroomId);

        if (classroom == null) {
            return "ERROR_SALON_NO_EXISTE";
        }

        switch (operation) {
            case "CONSULTAR_SALON":
                return handleConsult(classroom);

            case "RESERVAR_SALON":
                return handleReserve(classroom, repository);

            case "LIBERAR_SALON":
                return handleRelease(classroom, repository);

            default:
                return "ERROR: unknown operation. Use CONSULTAR_SALON, RESERVAR_SALON or LIBERAR_SALON";
        }
    }

    /**
     * Check if the classroom is available or reserved.
     * This does not change anything, it only reads the current state.
     *
     * @param classroom the classroom to check
     * @return SALON_DISPONIBLE if free, SALON_RESERVADO if not free
     */
    private static String handleConsult(Classroom classroom) {
        if (classroom.getAvailable()) {
            return "SALON_DISPONIBLE";
        } else {
            return "SALON_RESERVADO";
        }
    }

    /**
     * Try to reserve the classroom.
     * If the classroom is already reserved, we cannot reserve it again.
     *
     * @param classroom the classroom to reserve
     * @param repository the repository to save the change
     * @return RESERVA_EXITOSA if it worked, ERROR_OPERACION_INVALIDA if already reserved
     */
    private static String handleReserve(Classroom classroom, ClassroomRepository repository) {
        if (!classroom.getAvailable()) {
            return "ERROR_OPERACION_INVALIDA";
        }
        repository.reserveClassroom(classroom);
        return "RESERVA_EXITOSA";
    }

    /**
     * Try to release the classroom.
     * If the classroom is already free, we cannot release it again.
     *
     * @param classroom the classroom to release
     * @param repository the repository to save the change
     * @return LIBERACION_EXITOSA if it worked, ERROR_OPERACION_INVALIDA if already free
     */
    private static String handleRelease(Classroom classroom, ClassroomRepository repository) {
        if (classroom.getAvailable()) {
            return "ERROR_OPERACION_INVALIDA";
        }
        repository.releaseClassroom(classroom);
        return "LIBERACION_EXITOSA";
    }
}
