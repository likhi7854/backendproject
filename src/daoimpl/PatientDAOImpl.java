package daoimpl;

import dao.PatientDAO;
import database.DataBase;
import model.Patient;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {


    @Override
    public void insertPatient(Patient patient) {

        try {
            String sql = """
                    INSERT INTO patient
                    (patient_name, age, gender, phoneNumber, address, date_of_birth)
                    VALUES (?, ?, ?, ?, ?, ?)
                    """;

            Connection con = DataBase.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, patient.getPatient_name());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());
            ps.setString(5, patient.getAddress());
            ps.setDate(6, Date.valueOf(patient.getDate_of_birth()));

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Patient inserted successfully.");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Patient> getAllPatients() {

        List<Patient> patients = new ArrayList<>();

        try {
            String sql = "SELECT * FROM patient";

            Connection con = DataBase.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int patientId = rs.getInt("patient_id");
                String name = rs.getString("patient_name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String phone = rs.getString("phoneNumber");
                String address = rs.getString("address");
                String dob = rs.getString("date_of_birth");

                Patient patient = new Patient(
                        name,
                        age,
                        gender,
                        phone,
                        address,
                        dob
                );

                patient.setPatientId(patientId);

                patients.add(patient);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return patients;
    }

    @Override
    public void updatePatient(Patient patient) {

        try {
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


    @Override
    public void deletePatient(int patientId) {

        try {
            String sql = "DELETE FROM patient WHERE patient_id = ?";

            Connection con = DataBase.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, patientId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Patient deleted successfully.");
            } else {
                System.out.println("Patient ID not found.");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Override
    public boolean patientExists(int patientId) {

        try {
            String sql = "SELECT patient_id FROM patient WHERE patient_id = ?";

            Connection con = DataBase.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, patientId);

            ResultSet rs = ps.executeQuery();

            boolean exists = rs.next();

            rs.close();
            ps.close();
            con.close();

            return exists;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}