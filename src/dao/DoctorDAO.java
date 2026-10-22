package dao;

import model.Doctor;

import java.util.List;

public interface DoctorDAO {
      void  insertDoctor(Doctor doctor);
      List<Doctor> getAllDoctor();
      void  updateDoctor(Doctor doctor);
      void  deleteDoctor(int doctor_id);
}
