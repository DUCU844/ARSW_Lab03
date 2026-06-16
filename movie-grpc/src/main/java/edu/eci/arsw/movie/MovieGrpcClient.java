package edu.eci.arsw.movie;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

/**
 * This is the gRPC client for movies.
 * It opens a channel to the server and calls GetMovie.
 *
 * A "blocking stub" means the client waits for the server response
 * before continuing (simple, synchronous call).
 *
 * How to run:
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.movie.MovieGrpcClient"
 */
public class MovieGrpcClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        MovieServiceGrpc.MovieServiceBlockingStub stub =
                MovieServiceGrpc.newBlockingStub(channel);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter movie ID: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        MovieRequest request = MovieRequest.newBuilder()
                .setId(id)
                .build();

        MovieResponse response = stub.getMovie(request);

        if (response.getFound()) {
            System.out.println("Movie: " + response.getTitle()
                    + " | " + response.getDirector()
                    + " | " + response.getYear());
        } else {
            System.out.println("Movie not found.");
        }

        channel.shutdown();
    }
}
