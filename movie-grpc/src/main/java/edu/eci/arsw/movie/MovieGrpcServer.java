package edu.eci.arsw.movie;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the gRPC server for movies.
 * It listens on port 50051.
 *
 * Different from RMI and HTTP:
 * - The contract lives in movie.proto (not in Java interfaces or URL conventions)
 * - Maven generated the base classes from that file
 * - We only write the business logic inside the service implementation
 *
 * How to run:
 *   mvn clean compile
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.movie.MovieGrpcServer"
 */
public class MovieGrpcServer {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50051)
                .addService(new MovieServiceImpl())
                .build();

        server.start();
        System.out.println("Movie gRPC Server running on port 50051");
        server.awaitTermination();
    }

    /**
     * This class holds the real logic for the MovieService.
     * It extends the base class that Maven generated from movie.proto.
     *
     * We override getMovie() to search in our in-memory map.
     */
    static class MovieServiceImpl extends MovieServiceGrpc.MovieServiceImplBase {

        private Map<Integer, MovieResponse> movies = new HashMap<>();

        /**
         * Fill the movie data when the server starts.
         * We use MovieResponse.newBuilder() because that class was generated from the proto file.
         */
        public MovieServiceImpl() {
            movies.put(1, MovieResponse.newBuilder()
                    .setId(1).setTitle("Interstellar")
                    .setDirector("Christopher Nolan").setYear(2014).setFound(true).build());
            movies.put(2, MovieResponse.newBuilder()
                    .setId(2).setTitle("Matrix")
                    .setDirector("Wachowski").setYear(1999).setFound(true).build());
            movies.put(3, MovieResponse.newBuilder()
                    .setId(3).setTitle("Inception")
                    .setDirector("Christopher Nolan").setYear(2010).setFound(true).build());
        }

        /**
         * Handle the GetMovie RPC call.
         *
         * StreamObserver is how gRPC sends the response back.
         * onNext()      = send the result
         * onCompleted() = tell the client we are done
         *
         * @param request          the MovieRequest message from the client (has the id)
         * @param responseObserver the channel to send the response back
         */
        @Override
        public void getMovie(MovieRequest request, StreamObserver<MovieResponse> responseObserver) {
            MovieResponse response = movies.get(request.getId());

            if (response == null) {
                response = MovieResponse.newBuilder()
                        .setId(request.getId())
                        .setFound(false)
                        .build();
            }

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
