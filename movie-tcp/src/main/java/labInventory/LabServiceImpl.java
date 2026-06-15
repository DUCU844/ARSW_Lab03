package labInventory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class implements the LabService interface.
 * It extends UnicastRemoteObject so RMI can publish it in the registry.
 *
 * All equipment data is kept in memory using a Map.
 * The key is the equipment code (for example "PC-01").
 */
public class LabServiceImpl extends UnicastRemoteObject implements LabService {

    private Map<String, LabEquipment> inventory = new HashMap<>();

    /**
     * Create the service and fill the inventory with initial equipment.
     *
     * @throws RemoteException required by UnicastRemoteObject
     */
    public LabServiceImpl() throws RemoteException {
        inventory.put("PC-01", new LabEquipment("PC-01", "Desktop Computer", "Lab A", true));
        inventory.put("PC-02", new LabEquipment("PC-02", "Desktop Computer", "Lab A", false));
        inventory.put("RP-01", new LabEquipment("RP-01", "Raspberry Pi",     "Lab B", true));
        inventory.put("AR-01", new LabEquipment("AR-01", "Arduino Kit",      "Lab B", true));
        inventory.put("LP-01", new LabEquipment("LP-01", "Laptop",           "Lab C", false));
    }

    /**
     * Return all equipment as a list of text descriptions.
     *
     * @return list of strings, one per equipment
     * @throws RemoteException if the network call fails
     */
    @Override
    public List<String> consultarEquipos() throws RemoteException {
        List<String> result = new ArrayList<>();
        for (LabEquipment e : inventory.values()) {
            result.add(e.toString());
        }
        return result;
    }

    /**
     * Find one equipment by code and return its description.
     *
     * @param codigo the equipment code
     * @return text description, or error message if not found
     * @throws RemoteException if the network call fails
     */
    @Override
    public String consultarEquipo(String codigo) throws RemoteException {
        LabEquipment equipment = inventory.get(codigo);
        if (equipment == null) {
            return "ERROR: equipment not found -> " + codigo;
        }
        return equipment.toString();
    }

    /**
     * Reserve an equipment.
     * Only works if the equipment exists and is currently available.
     *
     * @param codigo the equipment code
     * @return true if reserved successfully, false otherwise
     * @throws RemoteException if the network call fails
     */
    @Override
    public boolean reservarEquipo(String codigo) throws RemoteException {
        LabEquipment equipment = inventory.get(codigo);
        if (equipment == null || !equipment.isAvailable()) {
            return false;
        }
        equipment.setAvailable(false);
        return true;
    }

    /**
     * Release an equipment.
     * Only works if the equipment exists and is currently reserved.
     *
     * @param codigo the equipment code
     * @return true if released successfully, false otherwise
     * @throws RemoteException if the network call fails
     */
    @Override
    public boolean liberarEquipo(String codigo) throws RemoteException {
        LabEquipment equipment = inventory.get(codigo);
        if (equipment == null || equipment.isAvailable()) {
            return false;
        }
        equipment.setAvailable(true);
        return true;
    }
}
