/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package paysys;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
/**
 *
 * @author Giann Gernale
 */
public class PaySys {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/payrolldb", "root",  "user123");
            Statement statement = con.createStatement(); 
            ResultSet RS = statement.executeQuery("select*from witholdingtaxmatrix");
            while (RS.next()) {
            // Get the number of columns
            ResultSetMetaData rsmd = RS.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            // Loop through each column and print its value
            for (int i = 1; i <= columnsNumber; i++) {
                String columnName = rsmd.getColumnName(i);
                String columnValue = RS.getString(i); // Adjust data type based on actual column type
                System.out.println(columnName + ": " + columnValue);
            }
            System.out.println(); // Add a newline after each row
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
