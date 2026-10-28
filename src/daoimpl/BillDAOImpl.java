package daoimpl;

import dao.BillDAO;
import database.DataBase;
import model.Bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BillDAOImpl implements BillDAO {

    @Override
    public void insertBill(Bill bill) {

        String sql = "INSERT INTO bill " +
                "(patient_id, appointment_id, consultation_fee, " +
                "medicine_charges, test_charges, total_amount, payment_status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DataBase.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, bill.getPatientId());
            ps.setInt(2, bill.getAppointmentId());
            ps.setDouble(3, bill.getConsultationFee());
            ps.setDouble(4, bill.getMedicineCharges());
            ps.setDouble(5, bill.getTestCharges());
            ps.setDouble(6, bill.getTotalAmount());
            ps.setString(7, bill.getPaymentStatus());

            ps.executeUpdate();

            System.out.println("Bill generated successfully.");

        } catch (Exception e) {
            System.out.println("Error while generating bill.");
            e.printStackTrace();
        }
    }


    @Override
    public List<Bill> getAllBills() {

        List<Bill> bills = new ArrayList<>();

        String sql = "SELECT * FROM bill";

        try (Connection con = DataBase.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Bill bill = new Bill();

                bill.setBillId(rs.getInt("bill_id"));
                bill.setPatientId(rs.getInt("patient_id"));
                bill.setAppointmentId(rs.getInt("appointment_id"));
                bill.setConsultationFee(rs.getDouble("consultation_fee"));
                bill.setMedicineCharges(rs.getDouble("medicine_charges"));
                bill.setTestCharges(rs.getDouble("test_charges"));
                bill.setTotalAmount(rs.getDouble("total_amount"));
                bill.setPaymentStatus(rs.getString("payment_status"));

                bills.add(bill);
            }

        } catch (Exception e) {
            System.out.println("Error while fetching bills.");
            e.printStackTrace();
        }

        return bills;
    }


    @Override
    public void updateBill(Bill bill) {

        String sql = "UPDATE bill SET " +
                "patient_id = ?, " +
                "appointment_id = ?, " +
                "consultation_fee = ?, " +
                "medicine_charges = ?, " +
                "test_charges = ?, " +
                "total_amount = ?, " +
                "payment_status = ? " +
                "WHERE bill_id = ?";

        try (Connection con = DataBase.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, bill.getPatientId());
            ps.setInt(2, bill.getAppointmentId());
            ps.setDouble(3, bill.getConsultationFee());
            ps.setDouble(4, bill.getMedicineCharges());
            ps.setDouble(5, bill.getTestCharges());
            ps.setDouble(6, bill.getTotalAmount());
            ps.setString(7, bill.getPaymentStatus());
            ps.setInt(8, bill.getBillId());

            ps.executeUpdate();

            System.out.println("Bill updated successfully.");

        } catch (Exception e) {
            System.out.println("Error while updating bill.");
            e.printStackTrace();
        }
    }


    @Override
    public void deleteBill(int billId) {

        String sql = "DELETE FROM bill WHERE bill_id = ?";

        try (Connection con = DataBase.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, billId);

            ps.executeUpdate();

            System.out.println("Bill deleted successfully.");

        } catch (Exception e) {
            System.out.println("Error while deleting bill.");
            e.printStackTrace();
        }
    }


    @Override
    public boolean billExists(int billId) {

        String sql = "SELECT bill_id FROM bill WHERE bill_id = ?";

        try (Connection con = DataBase.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, billId);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (Exception e) {
            System.out.println("Error while checking bill.");
            e.printStackTrace();
        }

        return false;
    }
}