package dao;

import model.Bill;

import java.util.List;

public interface BillDAO {
    void insertBill(Bill bill);
    List<Bill> getAllBills();
    void updateBill(Bill bill);
    void deleteBill(int billId);
    boolean billExists(int billId);
}