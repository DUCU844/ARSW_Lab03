package movies;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This is the remote interface for the movie service.
 * "Remote" means the method runs on the server, not on the client machine.
 *
 * Any method in a Remote interface must throw RemoteException.
 * This is because the call goes through the network and something can go wrong.
 */
public interface MovieService extends Remote {

    /**
     * Find a movie by its ID.
     * This method runs on the server but the client calls it like a local method.
     *
     * @param id the movie ID
     * @return the Movie object, or null if not found
     * @throws RemoteException if the network call fails
     */
    Movie getMovie(int id) throws RemoteException;
}
