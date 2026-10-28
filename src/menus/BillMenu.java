package menus;

import model.Bill;
import service.BillService;

import java.util.List;
import java.util.Scanner;

public class BillMenu {

    public static void billMenu(Scanner sc, BillService billService) {

        while (true) {

            System.out.println();
            System.out.println("========== BILLING MANAGEMENT ==========");
            System.out.println("1. Generate Bill");
            System.out.println("2. View Bills");
            System.out.println("3. Update Bill");
            System.out.println("4. Delete Bill");
            System.out.println("5. Back");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");
                continue;
            }


            switch (choice) {

                case 1:

                    generateBill(sc, billService);

                    break;


                case 2:

                    viewBills(billService);

                    break;


                case 3:

                    updateBill(sc, billService);

                    break;


                case 4:

                    deleteBill(sc, billService);

                    break;


                case 5:

                    return;


                default:

                    System.out.println("Invalid choice.");
            }
        }
    }


    private static void generateBill(
            Scanner sc,
            BillService billService) {

        try {

            System.out.println();
            System.out.println("========== GENERATE BILL ==========");

            System.out.print("Enter Patient ID: ");
            int patientId = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Appointment ID: ");
            int appointmentId = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Consultation Fee: ");
            double consultationFee =
                    Double.parseDouble(sc.nextLine());

            System.out.print("Enter Medicine Charges: ");
            double medicineCharges =
                    Double.parseDouble(sc.nextLine());

            System.out.print("Enter Test Charges: ");
            double testCharges =
                    Double.parseDouble(sc.nextLine());

            System.out.print("Enter Payment Status (Paid/Unpaid): ");
            String paymentStatus = sc.nextLine();


            Bill bill = new Bill(
                    patientId,
                    appointmentId,
                    consultationFee,
                    medicineCharges,
                    testCharges,
                    paymentStatus
            );


            System.out.println();
            System.out.println("Total Amount: ₹"
                    + bill.getTotalAmount());


            billService.generateBill(bill);


        } catch (NumberFormatException e) {

            System.out.println(
                    "Please enter valid numeric values.");

        }
    }


    private static void viewBills(
            BillService billService) {

        List<Bill> bills =
                billService.getAllBills();


        if (bills.isEmpty()) {

            System.out.println("No bills found.");

            return;
        }


        System.out.println();
        System.out.println("========== ALL BILLS ==========");


        for (Bill bill : bills) {

            System.out.println(
                    "Bill ID          : "
                            + bill.getBillId());

            System.out.println(
                    "Patient ID       : "
                            + bill.getPatientId());

            System.out.println(
                    "Appointment ID   : "
                            + bill.getAppointmentId());

            System.out.println(
                    "Consultation Fee : ₹"
                            + bill.getConsultationFee());

            System.out.println(
                    "Medicine Charges : ₹"
                            + bill.getMedicineCharges());

            System.out.println(
                    "Test Charges     : ₹"
                            + bill.getTestCharges());

            System.out.println(
                    "Total Amount     : ₹"
                            + bill.getTotalAmount());

            System.out.println(
                    "Payment Status   : "
                            + bill.getPaymentStatus());

            System.out.println(
                    "--------------------------------");
        }
    }


    private static void updateBill(
            Scanner sc,
            BillService billService) {

        try {

            System.out.println();
            System.out.println("========== UPDATE BILL ==========");

            System.out.print("Enter Bill ID: ");
            int billId = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Patient ID: ");
            int patientId = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Appointment ID: ");
            int appointmentId = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Consultation Fee: ");
            double consultationFee =
                    Double.parseDouble(sc.nextLine());

            System.out.print("Enter Medicine Charges: ");
            double medicineCharges =
                    Double.parseDouble(sc.nextLine());

            System.out.print("Enter Test Charges: ");
            double testCharges =
                    Double.parseDouble(sc.nextLine());

            System.out.print(
                    "Enter Payment Status (Paid/Unpaid): ");

            String paymentStatus = sc.nextLine();


            Bill bill = new Bill(
                    patientId,
                    appointmentId,
                    consultationFee,
                    medicineCharges,
                    testCharges,
                    paymentStatus
            );

            bill.setBillId(billId);


            billService.updateBill(bill);


        } catch (NumberFormatException e) {

            System.out.println(
                    "Please enter valid numeric values.");
        }
    }


    private static void deleteBill(
            Scanner sc,
            BillService billService) {

        try {

            System.out.print("Enter Bill ID: ");

            int billId =
                    Integer.parseInt(sc.nextLine());

            billService.deleteBill(billId);

        } catch (NumberFormatException e) {

            System.out.println(
                    "Please enter a valid Bill ID.");
        }
    }
}