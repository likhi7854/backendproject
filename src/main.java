import service.AppointmentService;
import service.BillService;
import service.DoctorService;
import service.PatientService;
import serviceimpl.AppointmentServiceImpl;
import serviceimpl.BillServiceImpl;
import serviceimpl.DoctorServiceImpl;
import serviceimpl.PatientServiceImpl;

import java.util.Scanner;

import static menus.PatientMenu.patientMenu;
import static menus.DoctorMenu.doctorMenu;
import static menus.AppointmentMenu.appointmentMenu;
import static menus.BillMenu.billMenu;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PatientService patientService = new PatientServiceImpl();
        DoctorService doctorService = new DoctorServiceImpl();
        AppointmentService appointmentService = new AppointmentServiceImpl();
        BillService billService = new BillServiceImpl();

        while (true) {

            System.out.println("\n ||   HOSPITAL MANAGEMENT SYSTEM ||\n");

            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Appointment Management");
            System.out.println("4. Billing Management");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    patientMenu(sc, patientService);
                    break;

                case 2:
                    doctorMenu(sc,doctorService);
                    break;

                case 3:
                   appointmentMenu(sc,appointmentService);
                    break;

                case 4:
                    billMenu(sc,billService);
                    break;

                case 5:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}