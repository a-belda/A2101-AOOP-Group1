/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paysys;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;
import java.sql.PreparedStatement;
/**
 *
 * @author Giann Gernale
 */
public class SimpleLogin {
    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);
        // Prompt the user to enter their username and password
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payrolldb", "root", "user123");
         Statement statement = con.createStatement()) {

      // Prepare a parameterized query to prevent SQL injection vulnerabilities
            String sql = "SELECT * FROM login WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet RS = preparedStatement.executeQuery();

            // Check if a valid login is found
            if (RS.next()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid username or password.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
