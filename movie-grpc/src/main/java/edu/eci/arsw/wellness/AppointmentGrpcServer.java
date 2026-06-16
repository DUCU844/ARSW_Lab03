package edu.eci.arsw.wellness;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * This is the gRPC server for the university wellness appointment system.
 * It listens on port 50052.
 *
 * The contract is defined in appointment.proto.
 * Maven generated the base classes from that file.
 *
 * Operations:
 *   RequestAppointment -> create a new appointment with status REQUESTED
 *   CancelAppointment  -> change an appointment status to CANCELLED
 *   GetAppointments    -> list all appointments for one student (only active ones)
 *
 * How to run:
 *   mvn clean compile
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.wellness.AppointmentGrpcServer"
 */
public class AppointmentGrpcServer {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50052)
                .addService(new AppointmentServiceImpl())
                .build();

        server.start();
        System.out.println("Wellness Appointment gRPC Server running on port 50052");
        server.awaitTermination();
    }

    /**
     * This class holds the real logic for the AppointmentService.
     * All appointments are kept in memory using a Map.
     * The key is the appointment ID (a random UUID string).
     */
    static class AppointmentServiceImpl extends AppointmentServiceGrpc.AppointmentServiceImplBase {

        private Map<String, Appointment> appointments = new HashMap<>();

        /**
         * Create a new appointment for a student.
         * The appointment always starts with status REQUESTED.
         * A random ID is generated for each appointment.
         *
         * @param request          the data from the client (student_id, service, date)
         * @param responseObserver the channel to send the response back
         */
        @Override
        public void requestAppointment(AppointmentRequest request,
                                       StreamObserver<AppointmentResponse> responseObserver) {
            String id = UUID.randomUUID().toString().substring(0, 8);

            Appointment appointment = Appointment.newBuilder()
                    .setAppointmentId(id)
                    .setStudentId(request.getStudentId())
                    .setService(request.getService())
                    .setDate(request.getDate())
                    .setStatus(AppointmentStatus.REQUESTED)
                    .build();

            appointments.put(id, appointment);

            AppointmentResponse response = AppointmentResponse.newBuilder()
                    .setAppointmentId(id)
                    .setSuccess(true)
                    .setMessage("Appointment created with ID: " + id)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        /**
         * Cancel an appointment by its ID.
         * If the ID does not exist, we return success = false.
         * A cancelled appointment stays in the map but with status CANCELLED.
         *
         * @param request          the cancel request with the appointment ID
         * @param responseObserver the channel to send the response back
         */
        @Override
        public void cancelAppointment(CancelRequest request,
                                      StreamObserver<CancelResponse> responseObserver) {
            Appointment existing = appointments.get(request.getAppointmentId());

            CancelResponse response;

            if (existing == null) {
                response = CancelResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("Appointment not found: " + request.getAppointmentId())
                        .build();
            } else if (existing.getStatus() == AppointmentStatus.CANCELLED) {
                response = CancelResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("Appointment is already cancelled.")
                        .build();
            } else {
                Appointment cancelled = existing.toBuilder()
                        .setStatus(AppointmentStatus.CANCELLED)
                        .build();
                appointments.put(request.getAppointmentId(), cancelled);

                response = CancelResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("Appointment cancelled.")
                        .build();
            }

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        /**
         * Get all active appointments for one student.
         * Cancelled appointments are not included in the result.
         *
         * @param request          the student request with the student ID
         * @param responseObserver the channel to send the response back
         */
        @Override
        public void getAppointments(StudentRequest request,
                                    StreamObserver<AppointmentList> responseObserver) {
            List<Appointment> result = new ArrayList<>();

            for (Appointment a : appointments.values()) {
                boolean sameStudent = a.getStudentId().equals(request.getStudentId());
                boolean isActive    = a.getStatus() != AppointmentStatus.CANCELLED;
                if (sameStudent && isActive) {
                    result.add(a);
                }
            }

            AppointmentList list = AppointmentList.newBuilder()
                    .addAllAppointments(result)
                    .build();

            responseObserver.onNext(list);
            responseObserver.onCompleted();
        }
    }
}
