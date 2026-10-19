package patient;
import database.DataBase;
import model.Patient;

import java.sql.DriverManager;
import  java.util.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class PatientInsert {
    public static void insertPatient() throws Exception {
        Scanner sc= new Scanner(System.in);
        String sql = "insert into patient (patient_name,age,gender,phoneNumber,address,date_of_birth) values (?,?,?,?,?,?)";
        Connection con = DataBase.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        System.out.println("Enter the Patient name: ");
        String name = sc.nextLine();
        System.out.println("Enter the patient age: ");
        int age  = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Gender: ");
        String gender = sc.nextLine();
        System.out.println("Enter the Phone number: ");
        String number = sc.nextLine();
        System.out.println("Enter the Address: ");
        String address = sc.nextLine();
        System.out.println("Enter the Date of Birth: ");
        String DOB = sc.nextLine();


        Patient patient = new Patient(
                name,
                age,
                gender,
                number,
                address,
                DOB
        );

        ps.setString(1, patient.getPatient_name());
        ps.setInt(2, patient.getAge());
        ps.setString(3, patient.getGender());
        ps.setString(4, patient.getPhone());
        ps.setString(5, patient.getAddress());
        ps.setDate(6, Date.valueOf(patient.getDate_of_birth()));

        int rows = ps.executeUpdate();

        System.out.println("Rows updated: " + rows);

        if (rows > 0) {
            System.out.println("Patient inserted successfully.");
        } else {
            System.out.println("Patient insertion failed.");
        }
        ps.close();
        con.close();
    }
}
