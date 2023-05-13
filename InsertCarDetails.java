package CarApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertCarDetails {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Car model!!");
        String model = sc.next();
        System.out.println("Enter Company Name!!");
        String company = sc.next();
        System.out.println("Enter category !!");
        String category = sc.next();
        System.out.println("Enter Price!!");
        double price = sc.nextDouble();

        String query = "insert into car_info(model,company,price,category) values('"+model+"','"+company+"',"+price+",'"+category+"')";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","sql123");
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Car Added Successfully!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (con!=null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (stmt!=null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}
