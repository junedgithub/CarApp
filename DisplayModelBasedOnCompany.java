package CarApp;

import java.sql.*;
import java.util.Scanner;

public class DisplayModelBasedOnCompany {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query = "select company, count(model) from car_info group by company";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "sql123");
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            System.out.println("Company\t\tCount");
            System.out.println("==================================================");
            while (rs.next()) {
                String company = rs.getString("company");
                int count = rs.getInt("count(model)");
                System.out.println(company+"\t\t"+count);
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
