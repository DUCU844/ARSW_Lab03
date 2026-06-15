package movies;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is the real implementation of the MovieService.
 * It extends UnicastRemoteObject so RMI can publish it in the registry.
 *
 * UnicastRemoteObject does the hard work: it opens the network connection
 * so clients can call methods on this object from another machine.
 */
public class MovieServiceImpl extends UnicastRemoteObject implements MovieService {

    private Map<Integer, Movie> movies = new HashMap<>();

    /**
     * Create the service and fill the movie data in memory.
     *
     * @throws RemoteException required by UnicastRemoteObject
     */
    public MovieServiceImpl() throws RemoteException {
        movies.put(1, new Movie(1, "Interstellar", "Christopher Nolan", 2014));
        movies.put(2, new Movie(2, "Matrix", "Wachowski", 1999));
        movies.put(3, new Movie(3, "Inception", "Christopher Nolan", 2010));
    }

    /**
     * Find a movie by ID.
     * RMI sends the result back to the client through the network automatically.
     *
     * @param id the movie ID
     * @return the Movie object, or null if not found
     * @throws RemoteException if the network call fails
     */
    @Override
    public Movie getMovie(int id) throws RemoteException {
        return movies.get(id);
    }
}
