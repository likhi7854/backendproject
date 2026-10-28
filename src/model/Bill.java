package model;

public class Bill {

    private int billId;
    private int patientId;
    private int appointmentId;

    private double consultationFee;
    private double medicineCharges;
    private double testCharges;

    private double totalAmount;

    private String paymentStatus;


    public Bill() {
    }


    public Bill(int patientId,
                int appointmentId,
                double consultationFee,
                double medicineCharges,
                double testCharges,
                String paymentStatus) {

        this.patientId = patientId;
        this.appointmentId = appointmentId;
        this.consultationFee = consultationFee;
        this.medicineCharges = medicineCharges;
        this.testCharges = testCharges;
        this.paymentStatus = paymentStatus;

        calculateTotalAmount();
    }


    public void calculateTotalAmount() {
        this.totalAmount =
                consultationFee +
                        medicineCharges +
                        testCharges;
    }


    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }


    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }


    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }


    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
        calculateTotalAmount();
    }


    public double getMedicineCharges() {
        return medicineCharges;
    }

    public void setMedicineCharges(double medicineCharges) {
        this.medicineCharges = medicineCharges;
        calculateTotalAmount();
    }


    public double getTestCharges() {
        return testCharges;
    }

    public void setTestCharges(double testCharges) {
        this.testCharges = testCharges;
        calculateTotalAmount();
    }


    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }


    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}