package edu.eci.arsw.wellness;

import edu.eci.arsw.gym.GymEmptyRequest;
import edu.eci.arsw.gym.GymServiceGrpc;
import edu.eci.arsw.gym.GymSession;
import edu.eci.arsw.gym.SessionRequest;
import edu.eci.arsw.gym.SessionResponse;
import edu.eci.arsw.gym.SessionList;
import edu.eci.arsw.medical.AvailabilityResponse;
import edu.eci.arsw.medical.MedicalEmptyRequest;
import edu.eci.arsw.medical.MedicalServiceGrpc;
import edu.eci.arsw.medical.Specialty;
import edu.eci.arsw.medical.SpecialtyRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

/**
 * This client connects to 3 independent wellness microservices:
 *   AppointmentService -> localhost:50052
 *   MedicalService     -> localhost:50055
 *   GymService         -> localhost:50056
 *
 * The client knows all ports directly — this is the problem that the
 * API Gateway (Part VI) will solve.
 *
 * How to run (start all services first):
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.wellness.AppointmentGrpcServer"
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.medical.MedicalGrpcServer"
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.gym.GymGrpcServer"
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.wellness.WellnessSystemClient"
 */
public class WellnessSystemClient {

    public static void main(String[] args) {
        ManagedChannel appointmentChannel = ManagedChannelBuilder
                .forAddress("localhost", 50052).usePlaintext().build();
        ManagedChannel medicalChannel = ManagedChannelBuilder
                .forAddress("localhost", 50055).usePlaintext().build();
        ManagedChannel gymChannel = ManagedChannelBuilder
                .forAddress("localhost", 50056).usePlaintext().build();

        AppointmentServiceGrpc.AppointmentServiceBlockingStub appointmentStub =
                AppointmentServiceGrpc.newBlockingStub(appointmentChannel);
        MedicalServiceGrpc.MedicalServiceBlockingStub medicalStub =
                MedicalServiceGrpc.newBlockingStub(medicalChannel);
        GymServiceGrpc.GymServiceBlockingStub gymStub =
                GymServiceGrpc.newBlockingStub(gymChannel);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Wellness System Client ===");
            System.out.println("1 - Request appointment");
            System.out.println("2 - See medical specialties");
            System.out.println("3 - See specialty availability");
            System.out.println("4 - See gym sessions");
            System.out.println("5 - Reserve gym session");
            System.out.println("0 - Exit");
            System.out.print("Option: ");

            String option = scanner.nextLine().trim();

            if (option.equals("0")) {
                System.out.println("Goodbye!");
                break;
            }

            switch (option) {

                case "1":
                    System.out.print("Student ID: ");
                    String sid = scanner.nextLine().trim();
                    System.out.println("Service: 0=MEDICINE, 1=PSYCHOLOGY, 2=DENTISTRY");
                    System.out.print("Number: ");
                    int svcNum = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Date (e.g. 2026-07-01): ");
                    String date = scanner.nextLine().trim();

                    AppointmentResponse apptResp = appointmentStub.requestAppointment(
                            AppointmentRequest.newBuilder()
                                    .setStudentId(sid)
                                    .setService(ServiceType.forNumber(svcNum))
                                    .setDate(date)
                                    .build());
                    System.out.println(apptResp.getMessage());
                    System.out.println("ID: " + apptResp.getAppointmentId());
                    break;

                case "2":
                    for (Specialty s : medicalStub
                            .getSpecialties(MedicalEmptyRequest.newBuilder().build())
                            .getSpecialtiesList()) {
                        System.out.println("- " + s.getName() + ": " + s.getDescription());
                    }
                    break;

                case "3":
                    System.out.print("Specialty (MEDICINE / PSYCHOLOGY / DENTISTRY): ");
                    String spec = scanner.nextLine().trim();
                    AvailabilityResponse avail = medicalStub.getAvailability(
                            SpecialtyRequest.newBuilder().setSpecialty(spec).build());
                    System.out.println("Available dates for " + avail.getSpecialty() + ":");
                    avail.getAvailableDatesList().forEach(d -> System.out.println("  - " + d));
                    break;

                case "4":
                    SessionList sessions = gymStub.getSessions(
                            GymEmptyRequest.newBuilder().build());
                    System.out.println("Gym sessions:");
                    for (GymSession gs : sessions.getSessionsList()) {
                        String status = gs.getAvailable() ? "AVAILABLE" : "FULL";
                        System.out.println("  " + gs.getTimeSlot() + " [" + status + "]");
                    }
                    break;

                case "5":
                    System.out.print("Student ID: ");
                    String gymSid = scanner.nextLine().trim();
                    System.out.print("Time slot (e.g. 07:00-08:00): ");
                    String slot = scanner.nextLine().trim();
                    SessionResponse gymResp = gymStub.reserveSession(
                            SessionRequest.newBuilder()
                                    .setStudentId(gymSid)
                                    .setTimeSlot(slot)
                                    .build());
                    System.out.println(gymResp.getMessage());
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        appointmentChannel.shutdown();
        medicalChannel.shutdown();
        gymChannel.shutdown();
    }
}
