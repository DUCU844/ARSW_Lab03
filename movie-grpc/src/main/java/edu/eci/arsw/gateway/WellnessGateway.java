package edu.eci.arsw.gateway;

import edu.eci.arsw.gym.GymEmptyRequest;
import edu.eci.arsw.gym.GymServiceGrpc;
import edu.eci.arsw.gym.GymSession;
import edu.eci.arsw.gym.SessionRequest;
import edu.eci.arsw.gym.SessionResponse;
import edu.eci.arsw.medical.AvailabilityResponse;
import edu.eci.arsw.medical.MedicalEmptyRequest;
import edu.eci.arsw.medical.MedicalServiceGrpc;
import edu.eci.arsw.medical.Specialty;
import edu.eci.arsw.medical.SpecialtyRequest;
import edu.eci.arsw.wellness.Appointment;
import edu.eci.arsw.wellness.AppointmentRequest;
import edu.eci.arsw.wellness.AppointmentResponse;
import edu.eci.arsw.wellness.AppointmentServiceGrpc;
import edu.eci.arsw.wellness.CancelRequest;
import edu.eci.arsw.wellness.CancelResponse;
import edu.eci.arsw.wellness.ServiceType;
import edu.eci.arsw.wellness.StudentRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

/**
 * This is the API Gateway for the wellness system.
 *
 * The user only talks to this Gateway — they do not know that
 * there are 3 separate microservices running on different ports.
 *
 * The Gateway hides:
 *   AppointmentService -> localhost:50052
 *   MedicalService     -> localhost:50055
 *   GymService         -> localhost:50056
 *
 * The user sees only one entry point with all operations unified.
 *
 * This shows the key benefit of a Gateway:
 * if a service moves to a different port or machine,
 * only the Gateway changes — not the user or the client code.
 *
 * How to run (start all 3 services first):
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.wellness.AppointmentGrpcServer"
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.medical.MedicalGrpcServer"
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.gym.GymGrpcServer"
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.gateway.WellnessGateway"
 */
public class WellnessGateway {

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
            System.out.println("\n=== Wellness Gateway ===");
            System.out.println("1 - Request appointment");
            System.out.println("2 - Cancel appointment");
            System.out.println("3 - Get my wellness summary");
            System.out.println("4 - Reserve gym session");
            System.out.println("0 - Exit");
            System.out.print("Option: ");

            String option = scanner.nextLine().trim();

            if (option.equals("0")) {
                System.out.println("Goodbye!");
                break;
            }

            switch (option) {

                case "1":
                    requestAppointment(scanner, appointmentStub);
                    break;

                case "2":
                    cancelAppointment(scanner, appointmentStub);
                    break;

                case "3":
                    /*
                     * getStudentWellnessSummary: aggregate data from 3 services.
                     * This shows the real power of a Gateway — one call to the user,
                     * but internally it hits multiple services and combines the result.
                     */
                    getWellnessSummary(scanner, appointmentStub, medicalStub, gymStub);
                    break;

                case "4":
                    reserveGymSession(scanner, gymStub);
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        appointmentChannel.shutdown();
        medicalChannel.shutdown();
        gymChannel.shutdown();
    }

    /**
     * Ask for student info and service type, then call AppointmentService.
     *
     * @param scanner         to read user input
     * @param appointmentStub the gRPC stub for AppointmentService
     */
    private static void requestAppointment(Scanner scanner,
            AppointmentServiceGrpc.AppointmentServiceBlockingStub appointmentStub) {

        System.out.print("Student ID: ");
        String studentId = scanner.nextLine().trim();
        System.out.println("Service: 0=MEDICINE  1=PSYCHOLOGY  2=DENTISTRY");
        System.out.print("Number: ");
        int svcNum = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Date (e.g. 2026-07-01): ");
        String date = scanner.nextLine().trim();

        AppointmentResponse response = appointmentStub.requestAppointment(
                AppointmentRequest.newBuilder()
                        .setStudentId(studentId)
                        .setService(ServiceType.forNumber(svcNum))
                        .setDate(date)
                        .build());

        System.out.println(response.getMessage());
        if (response.getSuccess()) {
            System.out.println("Appointment ID: " + response.getAppointmentId());
        }
    }

    /**
     * Ask for appointment ID and call AppointmentService to cancel it.
     *
     * @param scanner         to read user input
     * @param appointmentStub the gRPC stub for AppointmentService
     */
    private static void cancelAppointment(Scanner scanner,
            AppointmentServiceGrpc.AppointmentServiceBlockingStub appointmentStub) {

        System.out.print("Appointment ID to cancel: ");
        String apptId = scanner.nextLine().trim();

        CancelResponse response = appointmentStub.cancelAppointment(
                CancelRequest.newBuilder().setAppointmentId(apptId).build());

        System.out.println(response.getMessage());
    }

    /**
     * Show a combined wellness summary for one student.
     * Calls AppointmentService, MedicalService, and GymService internally.
     * The user sees one unified view — they do not know it came from 3 services.
     *
     * @param scanner         to read user input
     * @param appointmentStub the gRPC stub for AppointmentService
     * @param medicalStub     the gRPC stub for MedicalService
     * @param gymStub         the gRPC stub for GymService
     */
    private static void getWellnessSummary(Scanner scanner,
            AppointmentServiceGrpc.AppointmentServiceBlockingStub appointmentStub,
            MedicalServiceGrpc.MedicalServiceBlockingStub medicalStub,
            GymServiceGrpc.GymServiceBlockingStub gymStub) {

        System.out.print("Student ID: ");
        String studentId = scanner.nextLine().trim();

        System.out.println("\n======== Wellness Summary for " + studentId + " ========");

        // --- Active appointments from AppointmentService ---
        System.out.println("\n>> Active Appointments:");
        var apptList = appointmentStub.getAppointments(
                StudentRequest.newBuilder().setStudentId(studentId).build());

        if (apptList.getAppointmentsList().isEmpty()) {
            System.out.println("   No active appointments.");
        } else {
            for (Appointment a : apptList.getAppointmentsList()) {
                System.out.println("   [" + a.getAppointmentId() + "] "
                        + a.getService() + " on " + a.getDate()
                        + " (" + a.getStatus() + ")");
            }
        }

        // --- Available specialties from MedicalService ---
        System.out.println("\n>> Available Medical Specialties:");
        for (Specialty s : medicalStub
                .getSpecialties(MedicalEmptyRequest.newBuilder().build())
                .getSpecialtiesList()) {
            System.out.println("   - " + s.getName() + ": " + s.getDescription());
        }

        // --- Gym sessions from GymService ---
        System.out.println("\n>> Gym Sessions:");
        for (GymSession gs : gymStub
                .getSessions(GymEmptyRequest.newBuilder().build())
                .getSessionsList()) {
            String status = gs.getAvailable() ? "AVAILABLE" : "FULL";
            System.out.println("   " + gs.getTimeSlot() + " [" + status + "]");
        }

        System.out.println("==================================================");
    }

    /**
     * Ask for student ID and time slot, then call GymService to reserve.
     *
     * @param scanner to read user input
     * @param gymStub the gRPC stub for GymService
     */
    private static void reserveGymSession(Scanner scanner,
            GymServiceGrpc.GymServiceBlockingStub gymStub) {

        System.out.print("Student ID: ");
        String studentId = scanner.nextLine().trim();
        System.out.print("Time slot (e.g. 07:00-08:00): ");
        String slot = scanner.nextLine().trim();

        SessionResponse response = gymStub.reserveSession(
                SessionRequest.newBuilder()
                        .setStudentId(studentId)
                        .setTimeSlot(slot)
                        .build());

        System.out.println(response.getMessage());
    }
}
