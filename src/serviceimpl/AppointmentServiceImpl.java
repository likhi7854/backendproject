package serviceimpl;

import dao.AppointmentDAO;
import daoimpl.AppointmentDAOImpl;
import model.Appointment;
import service.AppointmentService;

import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentDAO appointmentDAO = new AppointmentDAOImpl();

    @Override
    public void bookAppointment(Appointment appointment) {

        if (!validateAppointment(appointment)) {
            return;
        }

        appointmentDAO.bookAppointment(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {

        return appointmentDAO.getAllAppointments();
    }

    @Override
    public void updateAppointment(Appointment appointment) {

        if (!appointmentDAO.appointmentExists(appointment.getAppointmentId())) {
            System.out.println("Appointment ID not found.");
            return;
        }

        if (!validateAppointment(appointment)) {
            return;
        }

        appointmentDAO.UpdateAppointment(appointment);
    }

    @Override
    public void deleteAppointment(int appointment_id) {

        if (!appointmentDAO.appointmentExists(appointment_id)) {
            System.out.println("Appointment ID not found.");
            return;
        }

        appointmentDAO.deleteAppointment(appointment_id);
    }

    private boolean validateAppointment(Appointment appointment) {

        if (appointment.getPatientId() <= 0) {
            System.out.println("Invalid Patient ID.");
            return false;
        }

        if (appointment.getDoctorId() <= 0) {
            System.out.println("Invalid Doctor ID.");
            return false;
        }

        if (appointment.getAppointmentDate() == null) {
            System.out.println("Appointment date cannot be empty.");
            return false;
        }

        if (appointment.getAppointmentTime() == null) {
            System.out.println("Appointment time cannot be empty.");
            return false;
        }

        if (appointment.getStatus() == null ||
                appointment.getStatus().trim().isEmpty()) {

            System.out.println("Appointment status cannot be empty.");
            return false;
        }

        return true;
    }
}