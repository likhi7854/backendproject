package dao;

import model.Patient;

import java.util.List;

public interface PatientDAO {
    void insertPatient(Patient patient);

    List<Patient> getAllPatients();

    void updatePatient(Patient patient);

    void deletePatient(int patientId);
    boolean patientExists(int patientId);

}
