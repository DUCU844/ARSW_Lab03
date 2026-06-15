package classroomManagement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * This is the TCP client for classrooms.
 * The user chooses an operation and a classroom ID.
 * The client sends the message to the server and shows the response.
 *
 * The program loops until the user types 0 to exit.
 * Each operation opens a new connection to the server and closes it after.
 *
 * The message format sent to the server is:
 *   OPERATION,CLASSROOM_ID
 * For example: RESERVAR_SALON,E303
 */
public class ClassroomClient {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("=== Classroom Management Client ===");

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1 - Check classroom status (CONSULTAR)");
            System.out.println("2 - Reserve a classroom (RESERVAR)");
            System.out.println("3 - Release a classroom (LIBERAR)");
            System.out.println("0 - Exit");
            System.out.print("Enter option: ");

            String option = input.nextLine().trim();

            if (option.equals("0")) {
                System.out.println("Goodbye!");
                break;
            }

            String operation;
            switch (option) {
                case "1":
                    operation = "CONSULTAR_SALON";
                    break;
                case "2":
                    operation = "RESERVAR_SALON";
                    break;
                case "3":
                    operation = "LIBERAR_SALON";
                    break;
                default:
                    System.out.println("Invalid option. Please use 0, 1, 2 or 3.");
                    continue;
            }

            System.out.print("Enter classroom ID (for example E303): ");
            String classroomId = input.nextLine().trim();

            String message = operation + "," + classroomId;

            Socket socket = new Socket("127.0.0.1", 12345);
            PrintWriter outToServer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader inFromServer = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            outToServer.println(message);

            String response = inFromServer.readLine();
            System.out.println("Server response: " + response);

            inFromServer.close();
            outToServer.close();
            socket.close();
        }
    }
}
