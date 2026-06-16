package edu.eci.arsw.gym;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Microservice responsible only for gym session reservations.
 * Runs on port 50056.
 *
 * This service does NOT know about medical appointments or recreation.
 * Each microservice owns its own data and logic.
 *
 * How to run:
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.gym.GymGrpcServer"
 */
public class GymGrpcServer {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50056)
                .addService(new GymServiceImpl())
                .build();

        server.start();
        System.out.println("GymService running on port 50056");
        server.awaitTermination();
    }

    static class GymServiceImpl extends GymServiceGrpc.GymServiceImplBase {

        private Map<String, GymSession> sessions = new HashMap<>();

        /**
         * Fill session data in memory.
         * Each session has a time slot, a max capacity, and availability.
         */
        public GymServiceImpl() {
            sessions.put("07:00-08:00", GymSession.newBuilder()
                    .setTimeSlot("07:00-08:00").setCapacity(10).setAvailable(true).build());
            sessions.put("08:00-09:00", GymSession.newBuilder()
                    .setTimeSlot("08:00-09:00").setCapacity(10).setAvailable(true).build());
            sessions.put("12:00-13:00", GymSession.newBuilder()
                    .setTimeSlot("12:00-13:00").setCapacity(10).setAvailable(false).build());
            sessions.put("17:00-18:00", GymSession.newBuilder()
                    .setTimeSlot("17:00-18:00").setCapacity(10).setAvailable(true).build());
        }

        /**
         * Return all gym sessions and their availability.
         *
         * @param request          empty request — no data needed
         * @param responseObserver channel to send the response back
         */
        @Override
        public void getSessions(GymEmptyRequest request,
                                StreamObserver<SessionList> responseObserver) {
            SessionList list = SessionList.newBuilder()
                    .addAllSessions(sessions.values())
                    .build();

            responseObserver.onNext(list);
            responseObserver.onCompleted();
        }

        /**
         * Try to reserve a gym session for a student.
         * Only works if the session exists and is available.
         * Marks the session as not available after reservation.
         *
         * @param request          contains student_id and time_slot
         * @param responseObserver channel to send the response back
         */
        @Override
        public void reserveSession(SessionRequest request,
                                   StreamObserver<SessionResponse> responseObserver) {
            GymSession session = sessions.get(request.getTimeSlot());

            SessionResponse response;

            if (session == null) {
                response = SessionResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("Session not found: " + request.getTimeSlot())
                        .build();
            } else if (!session.getAvailable()) {
                response = SessionResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("Session already full: " + request.getTimeSlot())
                        .build();
            } else {
                sessions.put(request.getTimeSlot(), session.toBuilder()
                        .setAvailable(false).build());

                response = SessionResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("Session reserved for " + request.getStudentId()
                                + " at " + request.getTimeSlot())
                        .build();
            }

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
