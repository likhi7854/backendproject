package daoimpl;

import dao.AppointmentDAO;
import database.DataBase;
import model.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAOImpl implements AppointmentDAO {
    @Override
    public void bookAppointment(Appointment appointment) {
        try {
            String sql ="""
                    INSERT INTO appointment
                        (appointmentId,  patient_id, doctor_id , appointment_date,  appointment_time, status)
                        VALUES (?, ?, ?, ?, ?, ?)
                        """;

            Connection con = DataBase.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, appointment.getAppointmentId());
            ps.setInt(2, appointment.getPatientId());
            ps.setInt(3, appointment.getDoctorId());
            ps.setDate(4, appointment.getAppointmentDate());
            ps.setTime(5, appointment.getAppointmentTime());
            ps.setString(6, appointment.getStatus());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Appointment inserted successfully.");
            }

            ps.close();
            con.close();
        }
    
    
         catch (Exception e) {
             e.printStackTrace();
         }
    }

    @Override
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();

        try {
            String sql = "SELECT * FROM appointment";

            Connection con = DataBase.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int appointmentId = rs.getInt("appointment_id");
                int patientId= rs.getInt("patient_id");
                int doctorId= rs.getInt("doctor_id");
                Date appointmentDate = rs.getDate(String.valueOf(Date.valueOf(rs.getString("appointment_date"))));
                Time appointmentTime = rs.getTime(String.valueOf(Time.valueOf(rs.getString("appointment_time"))));
                String status = rs.getString("status");

                Appointment appointment = new Appointment(patientId,doctorId,appointmentDate,appointmentTime,status);

                appointment.setAppointmentId(appointmentId);

                appointments.add(appointment);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return appointments;
    }



    @Override
    public void deleteAppointment(int appointmentId) {
        try {
            String sql = "DELETE FROM appointment WHERE appointment_id = ?";

            Connection con = DataBase.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, appointmentId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Appointment deleted successfully.");
            } else {
                System.out.println("Appointment ID not found.");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void UpdateAppointment(Appointment appointment) {

        try {
            String sql = """
                    UPDATE appointment
                    SET patient_id=?,doctor_id=?,appointment_date=?,appointment_time=?,status=?
                    WHERE appointment_id = ?
                    """;

            Connection con = DataBase.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, appointment.getAppointmentId());
            ps.setInt(2, appointment.getPatientId());
            ps.setInt(3, appointment.getDoctorId());
            ps.setDate(4, appointment.getAppointmentDate());
            ps.setTime(5, appointment.getAppointmentTime());
            ps.setString(6, appointment.getStatus());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Appointment updated successfully.");
            } else {
                System.out.println("Appointment ID not found.");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean appointmentExists(int appointmentId) {

        try {
            String sql = "SELECT appointment_id FROM appointment WHERE appointment_id = ?";

            Connection con = DataBase.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, appointmentId);

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
