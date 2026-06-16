package edu.eci.arsw.movie;

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
 * This client talks to 3 independent microservices at the same time:
 *   MovieService       -> localhost:50051
 *   ReviewService      -> localhost:50053
 *   RecommendationService -> localhost:50054
 *
 * This shows the problem with microservices without a Gateway:
 * the client must know the address and port of every service.
 *
 * How to run (start all 3 servers first):
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.movie.MovieGrpcServer"
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.review.ReviewGrpcServer"
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.recommendation.RecommendationGrpcServer"
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.movie.MovieSystemClient"
 */
public class MovieSystemClient {

    public static void main(String[] args) {
        ManagedChannel movieChannel = ManagedChannelBuilder
                .forAddress("localhost", 50051).usePlaintext().build();
        ManagedChannel reviewChannel = ManagedChannelBuilder
                .forAddress("localhost", 50053).usePlaintext().build();
        ManagedChannel recommendationChannel = ManagedChannelBuilder
                .forAddress("localhost", 50054).usePlaintext().build();

        MovieServiceGrpc.MovieServiceBlockingStub movieStub =
                MovieServiceGrpc.newBlockingStub(movieChannel);
        ReviewServiceGrpc.ReviewServiceBlockingStub reviewStub =
                ReviewServiceGrpc.newBlockingStub(reviewChannel);
        RecommendationServiceGrpc.RecommendationServiceBlockingStub recommendationStub =
                RecommendationServiceGrpc.newBlockingStub(recommendationChannel);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter movie ID (1, 2 or 3): ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        // --- Call MovieService ---
        MovieResponse movie = movieStub.getMovie(MovieRequest.newBuilder().setId(id).build());

        if (!movie.getFound()) {
            System.out.println("Movie not found.");
        } else {
            System.out.println("\n=== Movie Info ===");
            System.out.println("Title:    " + movie.getTitle());
            System.out.println("Director: " + movie.getDirector());
            System.out.println("Year:     " + movie.getYear());

            // --- Call ReviewService ---
            ReviewList reviewList = reviewStub.getReviews(
                    ReviewRequest.newBuilder().setMovieId(id).build());

            System.out.println("\n=== Reviews ===");
            if (reviewList.getReviewsList().isEmpty()) {
                System.out.println("No reviews found.");
            } else {
                for (Review r : reviewList.getReviewsList()) {
                    System.out.println("- " + r.getComment() + " (Rating: " + r.getRating() + ") - " + r.getAuthor());
                }
            }

            // --- Call RecommendationService ---
            RecommendationList recs = recommendationStub.getRecommendations(
                    RecommendationRequest.newBuilder().setMovieId(id).build());

            System.out.println("\n=== Recommendations ===");
            if (recs.getTitlesList().isEmpty()) {
                System.out.println("No recommendations found.");
            } else {
                for (String title : recs.getTitlesList()) {
                    System.out.println("- " + title);
                }
            }
        }

        movieChannel.shutdown();
        reviewChannel.shutdown();
        recommendationChannel.shutdown();
    }
}
