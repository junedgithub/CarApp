package CarApp;

import java.sql.*;
import java.util.Scanner;

public class EnterMInAndMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        System.out.println("Enter Min Price!!");
        int min = sc.nextInt();
        System.out.println("Enter Max Price!!");
        int max = sc.nextInt();
        String query = "select * from car_info where price between "+min+" and "+max;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "sql123");
            stmt = con.createStatement();
          rs =  stmt.executeQuery(query);
            System.out.println("ID\t\tMODEL\t\tCOMPANY\t\tPRICE\t\tCATEGORY");
          while(rs.next())
          {
              int id = rs.getInt(1);
              String model = rs.getString(2);
              String company = rs.getString(3);
              double price = rs.getDouble(4);
             String  category = rs.getString(5);
              System.out.println(id + "\t\t" + model + "\t\t" + company + "\t\t" + price + "\t\t" + category);
          }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally
        {
            if (con!=null)
            {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (stmt!=null)
            {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
