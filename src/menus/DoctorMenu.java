package menus;

import model.Doctor;
import service.DoctorService;

import java.util.List;
import java.util.Scanner;

public class DoctorMenu {
    public static void doctorMenu(Scanner sc, DoctorService doctorService) {

        while (true) {

            System.out.println("\n================================");
            System.out.println("      DOCTOR MANAGEMENT");
            System.out.println("================================");

            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctors");
            System.out.println("3. Update Doctor");
            System.out.println("4. Delete Doctor");
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

                    System.out.print("Enter Doctor Name: ");
                    String name = sc.nextLine();

                    System.out.println("Enter the Specialization :");
                    String specialization = sc.nextLine();

                    String gender;

                    while (true) {
                        System.out.print("Enter Gender (Male/Female/Other): ");
                        gender = sc.nextLine();

                        if (gender.equalsIgnoreCase("male") ||
                                gender.equalsIgnoreCase("female") ||
                                gender.equalsIgnoreCase("other")) {
                            break;
                        }

                        System.out.println("Please enter a valid gender.");
                    }

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Experience: ");

                    int experience;

                    try {
                        experience = sc.nextInt();
                        sc.nextLine();

                        if (experience < 0) {
                            System.out.println("experience must be greater than or equal to  0.");
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println("Please enter a valid experience.");
                        sc.nextLine();
                        break;
                    }

                    System.out.print("Enter consultationFee  : ");

                    double consultationFee;

                    try {
                        consultationFee = sc.nextDouble();
                        sc.nextLine();

                        if (consultationFee <= 0) {
                            System.out.println("consultation Fee must be greater than  0.");
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println("Please enter a valid consultation Fee.");
                        sc.nextLine();
                        break;
                    }


                    Doctor p = new Doctor(
                            name, specialization, gender, phone, email, experience, consultationFee
                    );

                    doctorService.addDoctor(p);

                    break;

                case 2:

                    List<Doctor> doctors = doctorService.getAllDoctor();

                    if (doctors.isEmpty()) {
                        System.out.println("No doctors found.");
                    } else {

                        for (Doctor doctor : doctors) {

                            System.out.println("\n----------------------------");
                            System.out.println("Doctor ID    :  " + doctor.getDoctor_id());
                            System.out.println("Name         :  " + doctor.getDoctor_name());
                            System.out.println("Specialization: " + doctor.getSpecialization());
                            System.out.println("Gender       :  " + doctor.getGender());
                            System.out.println("Phone        :  " + doctor.getPhone());
                            System.out.println("Email        :  " + doctor.getEmail());
                            System.out.println("Experience   :  " + doctor.getExperience());
                            System.out.println("consultation Fee :" + doctor.getConsultation_fee());
                            System.out.println("----------------------------");
                        }
                    }

                    break;

                case 3:

                    System.out.print("Enter Doctor ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Doctor Name: ");
                    String updateName = sc.nextLine();

                    System.out.print("Enter specialization: ");
                    String updateSpecialization = sc.nextLine();

                    String updateGender;

                    while (true) {
                        System.out.print("Enter Gender (Male/Female/Other): ");
                        updateGender = sc.nextLine();

                        if (updateGender.equalsIgnoreCase("male") ||
                                updateGender.equalsIgnoreCase("female") ||
                                updateGender.equalsIgnoreCase("other")) {
                            break;
                        }

                        System.out.println("Please enter a valid gender.");
                    }

                    System.out.print("Enter Phone: ");
                    String updatePhone = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String updateEmail = sc.nextLine();

                    System.out.print("Enter experience :  ");
                    int updateExperience = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter the Consultation Fee :");
                    double updateConsultationFee = sc.nextDouble();
                    sc.nextLine();

                    Doctor updateDoctor = new Doctor(
                            updateName,
                            updateSpecialization,
                            updateGender,
                            updatePhone,
                            updateEmail,
                            updateExperience,
                            updateConsultationFee

                    );

                    updateDoctor.setDoctor_id(id);

                    doctorService.updateDoctor(updateDoctor);

                    break;

                case 4:

                    System.out.print("Enter Doctor ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    doctorService.deleteDoctor(deleteId);

                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
}
