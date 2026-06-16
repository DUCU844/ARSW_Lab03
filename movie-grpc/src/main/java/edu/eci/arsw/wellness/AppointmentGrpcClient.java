package edu.eci.arsw.wellness;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

/**
 * This is the gRPC client for the wellness appointment system.
 * It connects to the server on port 50052 and calls the 3 operations.
 *
 * How to run:
 *   mvn exec:java -Dexec.mainClass="edu.eci.arsw.wellness.AppointmentGrpcClient"
 */
public class AppointmentGrpcClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50052)
                .usePlaintext()
                .build();

        AppointmentServiceGrpc.AppointmentServiceBlockingStub stub =
                AppointmentServiceGrpc.newBlockingStub(channel);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Wellness Appointment Client ===");
            System.out.println("1 - Request appointment");
            System.out.println("2 - Cancel appointment");
            System.out.println("3 - Get my appointments");
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
                    String studentId = scanner.nextLine().trim();

                    System.out.println("Service type: 0=MEDICINE, 1=PSYCHOLOGY, 2=DENTISTRY");
                    System.out.print("Enter number: ");
                    int serviceNum = Integer.parseInt(scanner.nextLine().trim());
                    ServiceType service = ServiceType.forNumber(serviceNum);

                    System.out.print("Date (e.g. 2026-07-15): ");
                    String date = scanner.nextLine().trim();

                    AppointmentRequest request = AppointmentRequest.newBuilder()
                            .setStudentId(studentId)
                            .setService(service)
                            .setDate(date)
                            .build();

                    AppointmentResponse response = stub.requestAppointment(request);
                    System.out.println(response.getMessage());
                    System.out.println("Appointment ID: " + response.getAppointmentId());
                    break;

                case "2":
                    System.out.print("Appointment ID to cancel: ");
                    String appointmentId = scanner.nextLine().trim();

                    CancelRequest cancelRequest = CancelRequest.newBuilder()
                            .setAppointmentId(appointmentId)
                            .build();

                    CancelResponse cancelResponse = stub.cancelAppointment(cancelRequest);
                    System.out.println(cancelResponse.getMessage());
                    break;

                case "3":
                    System.out.print("Student ID: ");
                    String sid = scanner.nextLine().trim();

                    StudentRequest studentRequest = StudentRequest.newBuilder()
                            .setStudentId(sid)
                            .build();

                    AppointmentList list = stub.getAppointments(studentRequest);

                    if (list.getAppointmentsList().isEmpty()) {
                        System.out.println("No active appointments found.");
                    } else {
                        System.out.println("Active appointments:");
                        for (Appointment a : list.getAppointmentsList()) {
                            System.out.println("  [" + a.getAppointmentId() + "] "
                                    + a.getService() + " on " + a.getDate()
                                    + " - " + a.getStatus());
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        channel.shutdown();
    }
}
