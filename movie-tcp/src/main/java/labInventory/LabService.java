package labInventory;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * This is the remote interface for the lab inventory service.
 * The client calls these methods as if they were local,
 * but they actually run on the server.
 *
 * All methods must throw RemoteException because they go through the network.
 */
public interface LabService extends Remote {

    /**
     * Get a list of all equipment with their current status.
     *
     * @return list of text descriptions, one per equipment
     * @throws RemoteException if the network call fails
     */
    List<String> consultarEquipos() throws RemoteException;

    /**
     * Get the details of one equipment by its code.
     *
     * @param codigo the equipment code, for example "PC-01"
     * @return text description, or an error message if not found
     * @throws RemoteException if the network call fails
     */
    String consultarEquipo(String codigo) throws RemoteException;

    /**
     * Reserve an equipment so only one person uses it.
     *
     * @param codigo the equipment code
     * @return true if the reservation worked, false if already reserved or not found
     * @throws RemoteException if the network call fails
     */
    boolean reservarEquipo(String codigo) throws RemoteException;

    /**
     * Release an equipment so other people can use it.
     *
     * @param codigo the equipment code
     * @return true if the release worked, false if already available or not found
     * @throws RemoteException if the network call fails
     */
    boolean liberarEquipo(String codigo) throws RemoteException;
}
