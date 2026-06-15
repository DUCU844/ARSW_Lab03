package labInventory;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

/**
 * This is the RMI client for the lab inventory.
 * It connects to the registry on port 24000 and calls methods on LabService.
 *
 * The client calls methods like service.reservarEquipo("PC-01").
 * This looks like a normal Java call, but it actually runs on the server.
 */
public class LabRmiClient {

    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 24000);
        LabService service = (LabService) registry.lookup("labService");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Lab Inventory Client ===");
            System.out.println("1 - List all equipment");
            System.out.println("2 - Check one equipment");
            System.out.println("3 - Reserve equipment");
            System.out.println("4 - Release equipment");
            System.out.println("0 - Exit");
            System.out.print("Option: ");

            String option = scanner.nextLine().trim();

            if (option.equals("0")) {
                System.out.println("Goodbye!");
                break;
            }

            switch (option) {
                case "1":
                    List<String> all = service.consultarEquipos();
                    System.out.println("--- All Equipment ---");
                    for (String item : all) {
                        System.out.println(item);
                    }
                    break;

                case "2":
                    System.out.print("Enter equipment code (e.g. PC-01): ");
                    String code2 = scanner.nextLine().trim();
                    System.out.println(service.consultarEquipo(code2));
                    break;

                case "3":
                    System.out.print("Enter equipment code to reserve: ");
                    String code3 = scanner.nextLine().trim();
                    boolean reserved = service.reservarEquipo(code3);
                    System.out.println(reserved ? "RESERVA_EXITOSA" : "ERROR: not found or already reserved");
                    break;

                case "4":
                    System.out.print("Enter equipment code to release: ");
                    String code4 = scanner.nextLine().trim();
                    boolean released = service.liberarEquipo(code4);
                    System.out.println(released ? "LIBERACION_EXITOSA" : "ERROR: not found or already available");
                    break;

                default:
                    System.out.println("Invalid option. Use 0, 1, 2, 3 or 4.");
            }
        }
    }
}
