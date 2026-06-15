package movies;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * This is the RMI client for movies.
 * It connects to the registry, gets the remote service, and calls getMovie().
 *
 * From the client's point of view, the call looks local:
 *   service.getMovie(1)
 * But the method actually runs on the server machine.
 */
public class MovieRmiClient {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter movie ID: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 23000);
        MovieService service = (MovieService) registry.lookup("movieService");

        Movie movie = service.getMovie(id);

        if (movie == null) {
            System.out.println("Movie not found.");
        } else {
            System.out.println("Movie received: " + movie.toText());
        }
    }
}
