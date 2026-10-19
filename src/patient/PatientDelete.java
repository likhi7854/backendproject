package patient;

import database.DataBase;

import javax.xml.crypto.Data;
import java.lang.ref.PhantomReference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PatientDelete {
     public static void patientDelete() {
         try {
             Scanner sc = new Scanner(System.in);
             System.out.println("Enter the Patient Id : ");
             int patient_id = sc.nextInt();
             String sql = "delete from patient where patient_id = ?";
             Connection con = DataBase.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(sql);
             preparedStatement.setInt(1,patient_id);
             int rows = preparedStatement.executeUpdate();

             if (rows > 0) {
                 System.out.println("Patient deleted successfully.");
             } else {
                 System.out.println("Patient not found.");
             }
             preparedStatement.close();
             con.close();
             sc.close();

         }
         catch (Exception e) {
             e.printStackTrace();

         }

     }
}
