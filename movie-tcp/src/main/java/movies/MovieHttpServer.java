package movies;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * This is the HTTP server for movies.
 * It listens on port 8080.
 *
 * To test it, open a browser and go to:
 *   http://localhost:8080/movie?id=1
 *
 * This is different from the TCP server.
 * Here we use HTTP, so any browser or tool like curl can talk to it.
 * We do not need a special Java client.
 */
public class MovieHttpServer {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        MovieRepository repository = new MovieRepository();

        server.createContext("/movie", new MovieHandler(repository));
        server.setExecutor(null);
        server.start();

        System.out.println("MovieHttpServer running at http://localhost:8080/movie?id=1");
    }

    /**
     * This handler runs every time someone sends a request to /movie.
     * It reads the id from the URL, finds the movie, and sends back HTML.
     */
    static class MovieHandler implements HttpHandler {

        private MovieRepository repository;

        /**
         * Create the handler with the repository it needs.
         *
         * @param repository the object that holds all movies in memory
         */
        public MovieHandler(MovieRepository repository) {
            this.repository = repository;
        }

        /**
         * Handle the HTTP request.
         * Read the query string, find the movie, and write the HTML response.
         *
         * @param exchange the object that holds the request and the response
         */
        @Override
        public void handle(HttpExchange exchange) {
            try {
                String query = exchange.getRequestURI().getQuery();
                int id = extractId(query);
                Movie movie = repository.findById(id);

                String response;
                if (movie == null) {
                    response = "<html><body><h1>Movie not found</h1></body></html>";
                } else {
                    response = "<html><body><h1>" + movie.toText() + "</h1></body></html>";
                }

                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * Read the id number from the query string.
         * The query string looks like: id=1
         * If the query is wrong or missing, we return -1.
         *
         * @param query the query string from the URL, for example "id=1"
         * @return the id as a number, or -1 if the query is not valid
         */
        private int extractId(String query) {
            if (query == null || !query.startsWith("id=")) {
                return -1;
            }
            return Integer.parseInt(query.substring(3));
        }
    }
}
