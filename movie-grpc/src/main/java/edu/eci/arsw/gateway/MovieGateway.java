package edu.eci.arsw.gateway;

import edu.eci.arsw.movie.MovieGrpcServer;
import edu.eci.arsw.movie.MovieRequest;
import edu.eci.arsw.movie.MovieResponse;
import edu.eci.arsw.movie.MovieServiceGrpc;
import edu.eci.arsw.recommendation.RecommendationList;
import edu.eci.arsw.recommendation.RecommendationRequest;
import edu.eci.arsw.recommendation.RecommendationServiceGrpc;
import edu.eci.arsw.review.Review;
import edu.eci.arsw.review.ReviewList;
import edu.eci.arsw.review.ReviewRequest;
import edu.eci.arsw.review.ReviewServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

/**
 * This is the API Gateway for the movie system.
 *
 * The user only talks to this Gateway — they do not know that
 * there are 3 separate services running on different ports.
 *
 * The Gateway:
 *   1. Receives the request from the user (movie ID)
 *   2. Calls MovieService, ReviewService, and RecommendationService internally
 *   3. Combines all responses into one unified output
 *
 * Internal connections (hidden from the user):
 *   MovieService          -> localhost:50051
 *   ReviewService         -> localhost:50053
 *   RecommendationService -> localhost:50054
 *
 * How to run (start all 3 services first, then the gateway):
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.movie.MovieGrpcServer"
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.review.ReviewGrpcServer"
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.recommendation.RecommendationGrpcServer"
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.gateway.MovieGateway"
 */
public class MovieGateway {

    public static void main(String[] args) {
        ManagedChannel movieChannel          = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        ManagedChannel reviewChannel         = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
        ManagedChannel recommendationChannel = ManagedChannelBuilder.forAddress("localhost", 50054).usePlaintext().build();

        MovieServiceGrpc.MovieServiceBlockingStub movieStub =
                MovieServiceGrpc.newBlockingStub(movieChannel);
        ReviewServiceGrpc.ReviewServiceBlockingStub reviewStub =
                ReviewServiceGrpc.newBlockingStub(reviewChannel);
        RecommendationServiceGrpc.RecommendationServiceBlockingStub recommendationStub =
                RecommendationServiceGrpc.newBlockingStub(recommendationChannel);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Movie Gateway ===");
            System.out.println("1 - Get full movie info");
            System.out.println("0 - Exit");
            System.out.print("Option: ");

            String option = scanner.nextLine().trim();

            if (option.equals("0")) {
                System.out.println("Goodbye!");
                break;
            }

            if (!option.equals("1")) {
                System.out.println("Invalid option.");
                continue;
            }

            System.out.print("Enter movie ID (1, 2 or 3): ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            MovieResponse movie = movieStub.getMovie(
                    MovieRequest.newBuilder().setId(id).build());

            if (!movie.getFound()) {
                System.out.println("Movie not found.");
                continue;
            }

            ReviewList reviews = reviewStub.getReviews(
                    ReviewRequest.newBuilder().setMovieId(id).build());

            RecommendationList recs = recommendationStub.getRecommendations(
                    RecommendationRequest.newBuilder().setMovieId(id).build());

            // --- Unified response ---
            System.out.println("\n----------------------------------------");
            System.out.println("Movie:    " + movie.getTitle());
            System.out.println("Director: " + movie.getDirector());
            System.out.println("Year:     " + movie.getYear());

            System.out.println("\nReviews:");
            if (reviews.getReviewsList().isEmpty()) {
                System.out.println("  No reviews.");
            } else {
                for (Review r : reviews.getReviewsList()) {
                    System.out.println("  - " + r.getComment()
                            + " (Rating: " + r.getRating() + ") - " + r.getAuthor());
                }
            }

            System.out.println("\nRecommendations:");
            if (recs.getTitlesList().isEmpty()) {
                System.out.println("  No recommendations.");
            } else {
                for (String title : recs.getTitlesList()) {
                    System.out.println("  - " + title);
                }
            }
            System.out.println("----------------------------------------");
        }

        movieChannel.shutdown();
        reviewChannel.shutdown();
        recommendationChannel.shutdown();
    }
}
