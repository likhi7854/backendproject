package serviceimpl;

import dao.BillDAO;
import daoimpl.BillDAOImpl;
import model.Bill;
import service.BillService;

import java.util.List;

public class BillServiceImpl implements BillService {

    private BillDAO billDAO = new BillDAOImpl();

    @Override
    public void generateBill(Bill bill) {
        if (!validateBill(bill)) {
            return;
        }
        bill.calculateTotalAmount();
        billDAO.insertBill(bill);
    }
    @Override
    public List<Bill> getAllBills() {

        return billDAO.getAllBills();
    }
    @Override
    public void updateBill(Bill bill) {

        if (!billDAO.billExists(bill.getBillId())) {
            System.out.println("Bill ID not found.");
            return;
        }
        if (!validateBill(bill)) {
            return;
        }
        bill.calculateTotalAmount();
        billDAO.updateBill(bill);
    }

    @Override
    public void deleteBill(int billId) {
        if (!billDAO.billExists(billId)) {
            System.out.println("Bill ID not found.");
            return;
        }
        billDAO.deleteBill(billId);
    }

    private boolean validateBill(Bill bill) {

        if (bill.getPatientId() <= 0) {
            System.out.println("Invalid Patient ID.");
            return false;
        }
        if (bill.getAppointmentId() <= 0) {
            System.out.println("Invalid Appointment ID.");
            return false;
        }
        if (bill.getConsultationFee() < 0) {
            System.out.println("Consultation fee cannot be negative.");
            return false;
        }
        if (bill.getMedicineCharges() < 0) {
            System.out.println("Medicine charges cannot be negative.");
            return false;
        }
        if (bill.getTestCharges() < 0) {
            System.out.println("Test charges cannot be negative.");
            return false;
        }
        if (bill.getPaymentStatus() == null || bill.getPaymentStatus().trim().isEmpty()) {
            System.out.println("Payment status cannot be empty.");
            return false;
        }

        if (!bill.getPaymentStatus().equalsIgnoreCase("Paid") && !bill.getPaymentStatus().equalsIgnoreCase("Unpaid")) {
            System.out.println("Payment status must be Paid or Unpaid.");
            return false;
        }
        return true;
    }
}