package menus;

import model.Appointment;
import service.AppointmentService;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Scanner;

public class AppointmentMenu {

    public static void appointmentMenu(
            Scanner sc,
            AppointmentService appointmentService) {

        while (true) {

            System.out.println(" \n   APPOINTMENT MANAGEMENT  \n");

            System.out.println("1. Book Appointment");
            System.out.println("2. View Appointments");
            System.out.println("3. Update Appointment");
            System.out.println("4. Delete Appointment");
            System.out.println("5. Back");

            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Please enter a number.");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.print("Enter Patient ID: ");
                    int patientId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Doctor ID: ");
                    int doctorId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Appointment Date (yyyy-MM-dd): ");
                    String dateInput = sc.nextLine();

                    Date appointmentDate;

                    try {
                        appointmentDate = Date.valueOf(dateInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid date. Use yyyy-MM-dd.");
                        break;
                    }

                    System.out.print("Enter Appointment Time (HH:mm:ss): ");
                    String timeInput = sc.nextLine();

                    Time appointmentTime;

                    try {
                        appointmentTime = Time.valueOf(timeInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid time. Use HH:mm:ss.");
                        break;
                    }

                    String status = "Scheduled";

                    Appointment appointment = new Appointment(patientId, doctorId, appointmentDate, appointmentTime, status);

                    appointmentService.bookAppointment(appointment);

                    break;

                case 2:

                    List<Appointment> appointments =
                            appointmentService.getAllAppointments();

                    if (appointments.isEmpty()) {

                        System.out.println("No appointments found.");

                    } else {

                        for (Appointment a : appointments) {
                            System.out.println("Appointment ID : " + a.getAppointmentId());
                            System.out.println("Patient ID     : " + a.getPatientId());
                            System.out.println("Doctor ID      : " + a.getDoctorId());
                            System.out.println("Date           : " + a.getAppointmentDate());
                            System.out.println("Time           : " + a.getAppointmentTime());
                            System.out.println("Status         : " + a.getStatus());


                        }
                    }

                    break;

                case 3:

                    System.out.print("Enter Appointment ID to update: ");
                    int appointmentId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Patient ID: ");
                    int updatePatientId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Doctor ID: ");
                    int updateDoctorId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Appointment Date (yyyy-MM-dd): ");

                    String updateDateInput = sc.nextLine();

                    Date updateDate;

                    try {
                        updateDate = Date.valueOf(updateDateInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid date. Use yyyy-MM-dd.");
                        break;
                    }

                    System.out.print("Enter Appointment Time (HH:mm:ss): ");

                    String updateTimeInput = sc.nextLine();

                    Time updateTime;

                    try {
                        updateTime = Time.valueOf(updateTimeInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid time. Use HH:mm:ss.");
                        break;
                    }

                    System.out.print("Enter Status (Scheduled/Completed/Cancelled): ");

                    String updateStatus = sc.nextLine();

                    Appointment updateAppointment = new Appointment(updatePatientId, updateDoctorId, updateDate, updateTime, updateStatus);

                    updateAppointment.setAppointmentId(appointmentId);
                    appointmentService.updateAppointment(updateAppointment);
                    break;

                case 4:

                    System.out.print( "Enter Appointment ID to delete: ");

                    int deleteId = sc.nextInt();
                    sc.nextLine();
                    appointmentService.deleteAppointment(deleteId);
                    break;
                case 5:
                    return;

                default:

                    System.out.println("Invalid choice!");
            }
        }
    }
}