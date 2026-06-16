package edu.eci.arsw.recommendation;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Microservice responsible only for movie recommendations.
 * Runs on port 50054, completely independent from the other services.
 *
 * How to run:
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.recommendation.RecommendationGrpcServer"
 */
public class RecommendationGrpcServer {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50054)
                .addService(new RecommendationServiceImpl())
                .build();

        server.start();
        System.out.println("RecommendationService running on port 50054");
        server.awaitTermination();
    }

    static class RecommendationServiceImpl
            extends RecommendationServiceGrpc.RecommendationServiceImplBase {

        private Map<Integer, List<String>> recommendations = new HashMap<>();

        /**
         * Fill the recommendation data in memory when the server starts.
         */
        public RecommendationServiceImpl() {
            recommendations.put(1, List.of("Inception", "Contact", "2001: A Space Odyssey"));
            recommendations.put(2, List.of("The Matrix Reloaded", "Blade Runner", "Ghost in the Shell"));
            recommendations.put(3, List.of("Interstellar", "Shutter Island", "Memento"));
        }

        /**
         * Return a list of recommended movie titles for the given movie.
         * If no recommendations exist, return an empty list.
         *
         * @param request          contains the movie ID
         * @param responseObserver channel to send the response back
         */
        @Override
        public void getRecommendations(RecommendationRequest request,
                                       StreamObserver<RecommendationList> responseObserver) {
            List<String> titles = recommendations.getOrDefault(request.getMovieId(), List.of());

            RecommendationList response = RecommendationList.newBuilder()
                    .addAllTitles(titles)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
