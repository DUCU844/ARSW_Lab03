package edu.eci.arsw.medical;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Microservice responsible only for medical specialties in the wellness center.
 * Runs on port 50055.
 *
 * This service does NOT know about appointments — that is AppointmentService's job.
 * Each service has one responsibility.
 *
 * How to run:
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.medical.MedicalGrpcServer"
 */
public class MedicalGrpcServer {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50055)
                .addService(new MedicalServiceImpl())
                .build();

        server.start();
        System.out.println("MedicalService running on port 50055");
        server.awaitTermination();
    }

    static class MedicalServiceImpl extends MedicalServiceGrpc.MedicalServiceImplBase {

        private Map<String, Specialty> specialties = new HashMap<>();
        private Map<String, List<String>> availability = new HashMap<>();

        /**
         * Fill specialty and availability data in memory.
         */
        public MedicalServiceImpl() {
            specialties.put("MEDICINE", Specialty.newBuilder()
                    .setName("MEDICINE")
                    .setDescription("General medicine consultations").build());
            specialties.put("PSYCHOLOGY", Specialty.newBuilder()
                    .setName("PSYCHOLOGY")
                    .setDescription("Psychological support and therapy").build());
            specialties.put("DENTISTRY", Specialty.newBuilder()
                    .setName("DENTISTRY")
                    .setDescription("Dental health and treatment").build());

            availability.put("MEDICINE",    List.of("2026-07-01", "2026-07-03", "2026-07-05"));
            availability.put("PSYCHOLOGY",  List.of("2026-07-02", "2026-07-04"));
            availability.put("DENTISTRY",   List.of("2026-07-07", "2026-07-09"));
        }

        /**
         * Return the list of all available medical specialties.
         *
         * @param request          empty request — no data needed
         * @param responseObserver channel to send the response back
         */
        @Override
        public void getSpecialties(MedicalEmptyRequest request,
                                   StreamObserver<SpecialtyList> responseObserver) {
            SpecialtyList list = SpecialtyList.newBuilder()
                    .addAllSpecialties(specialties.values())
                    .build();

            responseObserver.onNext(list);
            responseObserver.onCompleted();
        }

        /**
         * Return available dates for one specialty.
         *
         * @param request          contains the specialty name
         * @param responseObserver channel to send the response back
         */
        @Override
        public void getAvailability(SpecialtyRequest request,
                                    StreamObserver<AvailabilityResponse> responseObserver) {
            List<String> dates = availability.getOrDefault(request.getSpecialty(), List.of());

            AvailabilityResponse response = AvailabilityResponse.newBuilder()
                    .setSpecialty(request.getSpecialty())
                    .addAllAvailableDates(dates)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
