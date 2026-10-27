package serviceimpl;
import dao.DoctorDAO;
import daoimpl.DoctorDAOImpl;
import model.Doctor;
import service.DoctorService;
import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    private DoctorDAO doctorDAO = new DoctorDAOImpl();
    @Override
    public void addDoctor(Doctor doctor) {
        if (!validateDoctor(doctor)) {
            return;
        }
        doctorDAO.insertDoctor(doctor);
    }

    @Override
    public List<Doctor> getAllDoctor() {
        return doctorDAO.getAllDoctor();
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        if (!doctorDAO.doctorExists(doctor.getDoctor_id())) {
            System.out.println("doctor ID not found.");
            return;
        }
        if (!validateDoctor(doctor)) {
            return;
        }
        doctorDAO.updateDoctor(doctor);
    }

    @Override
    public void deleteDoctor(int doctor_id) {
        if (!doctorDAO.doctorExists(doctor_id)) {
            System.out.println("doctor ID not found.");
            return;
        }
        doctorDAO.deleteDoctor(doctor_id);
    }

    private boolean validateDoctor(Doctor doctor) {


        if (doctor.getExperience() < 0) {
            System.out.println("experience  must be greater than or equal to  0.");
            return false;
        }

        if (doctor.getPhone().length() != 10) {
            System.out.println("Phone number must contain 10 digits.");
            return false;
        }

        for (int i = 0; i < doctor.getPhone().length(); i++) {

            char ch = doctor.getPhone().charAt(i);

            if (ch < '0' || ch > '9') {
                System.out.println("Phone number must contain only digits.");
                return false;
            }
        }

        if (doctor.getConsultation_fee() <= 0) {
            System.out.println(" Consultation fee must be greater than 0.");
            return false;
        }
        if (doctor.getDoctor_name() == null || doctor.getDoctor_name().trim().isEmpty()) {

            System.out.println("Doctor name cannot be empty.");
            return false;
        }

        if (doctor.getSpecialization() == null || doctor.getSpecialization().trim().isEmpty()) {

            System.out.println("Specialization cannot be empty.");
            return false;
        }
        return true;
    }
}
