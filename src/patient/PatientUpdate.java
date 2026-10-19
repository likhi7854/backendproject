package patient;

import database.DataBase;
import model.Patient;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PatientUpdate {

    public static void patientUpdate() {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Patient ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Patient Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Gender: ");
            String gender = sc.nextLine();

            System.out.print("Enter Phone: ");
            String phone = sc.nextLine();

            System.out.print("Enter Address: ");
            String address = sc.nextLine();

            System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
            String dob = sc.nextLine();

            // Create Patient object
            Patient patient = new Patient(
                    name,
                    age,
                    gender,
                    phone,
                    address,
                    dob
            );

            patient.setPatientId(id);

            String sql = """
                    UPDATE patient
                    SET patient_name = ?,
                        age = ?,
                        gender = ?,
                        phoneNumber = ?,
                        address = ?,
                        date_of_birth = ?
                    WHERE patient_id = ?
                    """;

            Connection con = DataBase.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, patient.getPatient_name());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());
            ps.setString(5, patient.getAddress());
            ps.setDate(6, Date.valueOf(patient.getDate_of_birth()));
            ps.setInt(7, patient.getPatientId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Patient updated successfully.");
            } else {
                System.out.println("Patient ID not found.");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}