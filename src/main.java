import database.DataBase;
import patient.PatientInsert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        try {

            while (true) {
                  PatientInsert.insertPatient();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
