package service;

import model.Doctor;

import java.util.List;

public interface DoctorService {
    void  addDoctor(Doctor doctor);
    List<Doctor> getAllDoctor();
    void  updateDoctor(Doctor doctor);
    void  deleteDoctor(int doctor_id);
}
