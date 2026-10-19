package patient;

import database.DataBase;
import model.Patient;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PatientView {
     public static void patientView(){
            try {

                String sql = "select * from patient";
                Connection con = DataBase.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();
                List<Patient> patients = new ArrayList<>();
                while (rs.next()) {

                    int patient_id = rs.getInt("patient_id");
                    String patientName = rs.getString("patient_name");
                    int age = rs.getInt("age");
                    String gender = rs.getString("gender");
                    String phone = rs.getString("phoneNumber");
                    String address = rs.getString("address");
                    String dateOfBirth = rs.getString("date_of_birth");

                    Patient patient = new Patient(
                            patientName,
                            age,
                            gender,
                            phone,
                            address,
                            dateOfBirth
                    );

                    patient.setPatientId(patient_id);

                    patients.add(patient);
                }
                for (Patient patient : patients) {

                    System.out.println("Patient ID: " + patient.getPatientId());
                    System.out.println("Patient Name: " + patient.getPatient_name());
                    System.out.println("Age: " + patient.getAge());
                    System.out.println("Gender: " + patient.getGender());
                    System.out.println("Phone: " + patient.getPhone());
                    System.out.println("Address: " + patient.getAddress());
                    System.out.println("Date of Birth: " + patient.getDate_of_birth());
                    System.out.println("-------------------------------");
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
     }
}
