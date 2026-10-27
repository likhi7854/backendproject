package menus;

import model.Patient;
import service.PatientService;
import java.util.List;
import java.util.Scanner;

public class PatientMenu {
    public static void patientMenu(Scanner sc, PatientService patientService) {

        while (true) {

            System.out.println("\n================================");
            System.out.println("      PATIENT MANAGEMENT");
            System.out.println("================================");

            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
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

                    System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");

                    int age;

                    try {
                        age = sc.nextInt();
                        sc.nextLine();

                        if (age <= 0) {
                            System.out.println("Age must be greater than 0.");
                            break;
                        }

                    } catch (Exception e) {
                        System.out.println("Please enter a valid age.");
                        sc.nextLine();
                        break;
                    }

                    System.out.print("Enter Gender: ");

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

                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
                    String dob = sc.nextLine();

                    Patient p = new Patient(
                            name, age, gender, phone, address, dob
                    );

                    patientService.addPatient(p);

                    break;

                case 2:

                    List<Patient> patients = patientService.getAllPatients();
                    if (patients.isEmpty()) {
                        System.out.println("No patients found.");
                    } else {
                        for (Patient patient : patients) {
                                System.out.println("\n----------------------------");
                                System.out.println("Patient ID: " + patient.getPatientId());
                                System.out.println("Name: " + patient.getPatient_name());
                                System.out.println("Age: " + patient.getAge());
                                System.out.println("Gender: " + patient.getGender());
                                System.out.println("Phone: " + patient.getPhone());
                                System.out.println("Address: " + patient.getAddress());
                                System.out.println("Date of Birth: " + patient.getDate_of_birth());
                                System.out.println("----------------------------");

                        }
                    }

                    break;

                case 3:

                    System.out.print("Enter Patient ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String updateName = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int updateAge = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Gender: ");
                    String updateGender = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String updatePhone = sc.nextLine();

                    System.out.print("Enter Address: ");
                    String updateAddress = sc.nextLine();

                    System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
                    String updateDob = sc.nextLine();

                    Patient updatePatient = new Patient(
                            updateName,
                            updateAge,
                            updateGender,
                            updatePhone,
                            updateAddress,
                            updateDob
                    );

                    updatePatient.setPatientId(id);

                    patientService.updatePatient(updatePatient);

                    break;

                case 4:

                    System.out.print("Enter Patient ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    patientService.deletePatient(deleteId);

                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
