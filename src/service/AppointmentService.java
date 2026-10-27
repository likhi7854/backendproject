package service;

import model.Appointment;

import java.util.List;

public interface AppointmentService {
     void bookAppointment(Appointment appointment);
     List<Appointment> getAllAppointments();
     void  updateAppointment(Appointment appointment);
     void  deleteAppointment(int appointment_id);
}
