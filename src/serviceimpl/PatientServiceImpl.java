package serviceimpl;

import dao.PatientDAO;
import daoimpl.PatientDAOImpl;
import model.Patient;
import service.PatientService;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import java.util.List;

public class PatientServiceImpl implements PatientService {

    private PatientDAO patientDAO = new PatientDAOImpl();

    @Override
    public void addPatient(Patient patient) {
        if (!validatePatient(patient)) {
            return;
        }

        patientDAO.insertPatient(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }

    @Override
    public void updatePatient(Patient patient) {
        if (!patientDAO.patientExists(patient.getPatientId())) {
            System.out.println("Patient ID not found.");
            return;
        }
        if (!validatePatient(patient)) {
            return;
        }
        patientDAO.updatePatient(patient);
    }

    @Override
    public void deletePatient(int patientId) {
        if (!patientDAO.patientExists(patientId)) {
            System.out.println("Patient ID not found.");
            return;
        }
        patientDAO.deletePatient(patientId);
    }

    private boolean validatePatient(Patient patient) {


        if (patient.getAge() <= 0) {
            System.out.println("Age must be greater than 0.");
            return false;
        }

        if (patient.getPhone().length() != 10) {
            System.out.println("Phone number must contain 10 digits.");
            return false;
        }

        for (int i = 0; i < patient.getPhone().length(); i++) {

            char ch = patient.getPhone().charAt(i);

            if (ch < '0' || ch > '9') {
                System.out.println("Phone number must contain only digits.");
                return false;
            }
        }

        try {
            LocalDate dob = LocalDate.parse(patient.getDate_of_birth());

            if (dob.isAfter(LocalDate.now())) {
                System.out.println("Date of birth cannot be a future date.");
                return false;
            }

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date. Use yyyy-MM-dd.");
            return false;
        }

        return true;
    }
}