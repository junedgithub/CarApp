package CarApp;

import java.sql.*;
import java.util.Scanner;

public class DisplayModel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        System.out.println("Enter company");
        String company = sc.next();
        System.out.println("Enter Category!!");
        String category = sc.next();
        String query = "select model from car_info where category= '"+category+"' and company= '"+company+"'";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "sql123");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            System.out.println("ID\t\tMODEL\t\tCOMPANY\t\tPRICE\t\tCATEGORY");
            System.out.println("==================================================");
            while (rs.next()) {


                String model = rs.getString("model");
                System.out.println(model);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}
