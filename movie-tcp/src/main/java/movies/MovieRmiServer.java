package movies;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * This is the RMI server for movies.
 * It creates a registry on port 23000 and registers the MovieService.
 *
 * The registry works like a phone book:
 * the server puts its service there with a name ("movieService"),
 * and the client looks it up by that name.
 *
 * How to run:
 *   java movies.MovieRmiServer
 *
 * Then in another terminal:
 *   java movies.MovieRmiClient
 */
public class MovieRmiServer {

    public static void main(String[] args) throws Exception {
        MovieService service = new MovieServiceImpl();
        Registry registry = LocateRegistry.createRegistry(23000);
        registry.rebind("movieService", service);
        System.out.println("MovieService RMI running on port 23000...");
    }
}
