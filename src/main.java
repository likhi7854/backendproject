import menus.DoctorMenu;
import service.DoctorService;
import service.PatientService;
import serviceimpl.DoctorServiceImpl;
import serviceimpl.PatientServiceImpl;

import java.util.Scanner;

import static menus.PatientMenu.patientMenu;
import static menus.DoctorMenu.doctorMenu;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PatientService patientService = new PatientServiceImpl();
        DoctorService doctorService = new DoctorServiceImpl();

        while (true) {

            System.out.println("\n================================");
            System.out.println(" ||   HOSPITAL MANAGEMENT SYSTEM ||");
            System.out.println("================================");

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
                    System.out.println("Appointment Management - Coming Soon");
                    break;

                case 4:
                    System.out.println("Billing Management - Coming Soon");
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