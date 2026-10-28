package service;

import model.Bill;

import java.util.List;

public interface BillService {

    void generateBill(Bill bill);

    List<Bill> getAllBills();

    void updateBill(Bill bill);

    void deleteBill(int billId);
}