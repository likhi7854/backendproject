package model;

public class Patient {


        private int patientId;
        private String patient_name;
        private int age;
        private String gender;
        private String phone;
        private String address;
        private String date_of_birth ;

        public Patient() {
        }

        public Patient(String patient_name, int age, String gender, String phone, String address, String date_of_birth) {
            this.patient_name = patient_name;
            this.age = age;
            this.gender = gender;
            this.phone = phone;
            this.address = address;
            this.date_of_birth = date_of_birth;
        }

        public int getPatientId() {
            return patientId;
        }

        public void setPatientId(int patientId) {
            this.patientId = patientId;
        }

        public String getPatient_name() {
            return patient_name;
        }

        public void setPatient_name(String patient_name) {
            this.patient_name = patient_name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getDate_of_birth() {
            return date_of_birth;
        }

        public void setDate_of_birth(String date_of_birth) {
            this.date_of_birth = date_of_birth;
        }
}
