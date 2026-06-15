package labInventory;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * This is the RMI server for the lab inventory.
 * It creates a registry on port 24000 and registers the LabService.
 *
 * How to run:
 *   java labInventory.LabRmiServer
 *
 * Then in another terminal:
 *   java labInventory.LabRmiClient
 */
public class LabRmiServer {

    public static void main(String[] args) throws Exception {
        LabService service = new LabServiceImpl();
        Registry registry = LocateRegistry.createRegistry(24000);
        registry.rebind("labService", service);
        System.out.println("LabService RMI running on port 24000...");
    }
}
