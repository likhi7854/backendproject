package model;

public class Doctor {
    private int doctor_id;
    private String doctor_name;
    private String Specialization;
    private String gender;
    private String phone;
    private String email;
    private int experience;
    private double consultation_fee;

    public Doctor( String doctor_name, String specialization, String gender, String phone, String email, int experience, double consultation_fee) {
        this.doctor_name = doctor_name;
        this.Specialization = specialization;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.experience = experience;
        this.consultation_fee = consultation_fee;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public double getConsultation_fee() {
        return consultation_fee;
    }

    public void setConsultation_fee(double consultation_fee) {
        this.consultation_fee = consultation_fee;
    }
}
