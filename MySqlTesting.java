package org.example;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.*;

public class MySqlTesting {

    static Connection con = null;
    private static Statement stmt;
    public static String DB_URl = "jdbc:mysql://localhost:3306/Orange?serverTimezone=UTC";
    public static String DB_USER = "root";
    public static String DB_PASSWORD = "Welcome1";

    @BeforeMethod
    public static void setUp(){


        try {
            String dbClass = "com.mysql.cj.jdbc.Driver";
            Class.forName(dbClass).newInstance();
            Connection con = DriverManager.getConnection(DB_URl,DB_USER,DB_PASSWORD);
            stmt = con.createStatement();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test

    public void test(){


        try {
            String query = "select * from users";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()){

                System.out.print(res.getString(1));
                System.out.print("\t"+res.getString(2));
                System.out.print("\t"+res.getString(3));
                System.out.println("\t"+res.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @AfterMethod
    public void tearDown() throws Exception {
        // Close DB connection
        if (con != null) {
            con.close();
        }
    }

}
