package daoimpl;

import dao.DoctorDAO;
import database.DataBase;
import model.Doctor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {

    @Override
    public void insertDoctor(Doctor doctor) {
        String sql = """
                            Insert into doctor (Doctor_name,Specialization,gender,phone,Email_id,experience,consultation_fee ) 
                            value(?,?,?,?,?,?,?,?)
                      """;
        try {
                Connection con = DataBase.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, doctor.getDoctor_name());
                ps.setString(2, doctor.getSpecialization());
                ps.setString(3, doctor.getGender());
                ps.setString(4, doctor.getPhone());
                ps.setString(5, doctor.getEmail());
                ps.setInt(6, doctor.getExperience());
                ps.setDouble(7, doctor.getConsultation_fee());
                ps.executeUpdate();
                int rows = ps.executeUpdate();

                if (rows > 0) {
                    System.out.println("Doctor inserted successfully.");
                }

                ps.close();
                con.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Doctor> getAllDoctor() {
         List<Doctor> doctors =new  ArrayList<>();
         try{
             String sql = "select * from doctor";
             Connection con  = DataBase.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery();
             while(rs.next()){
                 int id = rs.getInt("doctor_id");
                 String name = rs.getString("doctor_name");
                 String specialization  = rs.getString("Specialization");
                 String gender = rs.getString("gender");
                 String phoNo = rs.getString("phoneNumber");
                 String email = rs.getString("email");
                 int experience = rs.getInt("experience");
                 float consultation_fee = rs.getFloat("consultation_fee");

                 Doctor doctor = new Doctor(name,specialization,gender,phoNo,email,experience,consultation_fee);
                 doctor.setDoctor_id(id);
                 doctors.add(doctor);

             }
             rs.close();
             preparedStatement.close();
             con.close();
         }
         catch (Exception e){
             e.printStackTrace();
         }
         return  doctors;

    }

    @Override
    public void updateDoctor(Doctor doctor) {
          try{
                String sql = """
                          update doctor 
                             set  doctor_name=?,
                             specialization=?,
                             gender =?,
                             phoneNumber =?,
                             email =?,
                             experience =?,
                             consultation_fee=?
                             where doctor_id = ?
                       
                        """;
              Connection con  = DataBase.getConnection();
              PreparedStatement ps = con.prepareStatement(sql);
              ps.setString(1, doctor.getDoctor_name());
              ps.setString(2, doctor.getSpecialization());
              ps.setString(3, doctor.getGender());
              ps.setString(4, doctor.getPhone());
              ps.setString(5, doctor.getEmail());
              ps.setInt(6, doctor.getExperience());
              ps.setDouble(7, doctor.getConsultation_fee());
              ps.executeUpdate();
              int rows = ps.executeUpdate();

              if (rows > 0) {
                  System.out.println("Doctor inserted successfully.");
              }

              ps.close();
              con.close();
          }
          catch (Exception e){
              e.printStackTrace();
          }

    }

    @Override
    public void deleteDoctor(int doctor_id) {

    }
}
