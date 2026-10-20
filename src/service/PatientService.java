package service;

import model.Patient;

import java.util.List;

public interface PatientService {

    void addPatient(Patient patient);

    List<Patient> getAllPatients();

    void updatePatient(Patient patient);

    void deletePatient(int patientId);
}