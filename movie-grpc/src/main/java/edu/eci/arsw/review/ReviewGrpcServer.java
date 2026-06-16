package edu.eci.arsw.review;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Microservice responsible only for movie reviews.
 * Runs on port 50053, completely independent from MovieService and RecommendationService.
 *
 * How to run:
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.review.ReviewGrpcServer"
 */
public class ReviewGrpcServer {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50053)
                .addService(new ReviewServiceImpl())
                .build();

        server.start();
        System.out.println("ReviewService running on port 50053");
        server.awaitTermination();
    }

    static class ReviewServiceImpl extends ReviewServiceGrpc.ReviewServiceImplBase {

        private Map<Integer, List<Review>> reviewMap = new HashMap<>();

        /**
         * Fill the review data in memory when the server starts.
         */
        public ReviewServiceImpl() {
            reviewMap.put(1, List.of(
                    Review.newBuilder().setAuthor("Ana").setComment("Excellent sci-fi film.").setRating(5).build(),
                    Review.newBuilder().setAuthor("Luis").setComment("Visually impressive.").setRating(4).build()
            ));
            reviewMap.put(2, List.of(
                    Review.newBuilder().setAuthor("Carlos").setComment("Classic.").setRating(5).build()
            ));
            reviewMap.put(3, List.of(
                    Review.newBuilder().setAuthor("Maria").setComment("Mind-bending story.").setRating(5).build(),
                    Review.newBuilder().setAuthor("Pedro").setComment("Very good direction.").setRating(4).build()
            ));
        }

        /**
         * Return all reviews for one movie.
         * If no reviews exist for that movie, return an empty list.
         *
         * @param request          contains the movie ID
         * @param responseObserver channel to send the response back
         */
        @Override
        public void getReviews(ReviewRequest request, StreamObserver<ReviewList> responseObserver) {
            List<Review> reviews = reviewMap.getOrDefault(request.getMovieId(), List.of());

            ReviewList response = ReviewList.newBuilder()
                    .addAllReviews(reviews)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
