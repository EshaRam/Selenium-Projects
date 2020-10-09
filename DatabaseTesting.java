package org.example;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.Iterator;

public class DatabaseTesting {
    // Connection object
    static Connection con = null;
    // Statement object
    private static Statement stmt;
    // Constant for Database URL
    public static String DB_URL = "jdbc:mysql://localhost:3306/Orange?serverTimezone=UTC";
    // Constant for Database Username
    public static String DB_USER = "root";
    // Constant for Database Password
    public static String DB_PASSWORD = "Welcome1";

    @BeforeMethod
    public static void setUp() throws Exception {
        try{
            // Make the database connection
            String dbClass = "com.mysql.cj.jdbc.Driver";
            Class.forName(dbClass).newInstance();
            // Get connection to DB
            Connection con = DriverManager.getConnection(DB_URL, DB_USER,DB_PASSWORD);
            // Statement object to send the SQL statement to the Database
            stmt = con.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void  test() {

        try {
            String query = "select * from users";
            // Get the contents of userinfo table from DB

            ResultSet   res = stmt.executeQuery(query);
            // Print the result untill all the records are printed
            // res.next() returns true if there is any next record else returns false
            while (res.next()) {
                System.out.print(res.getString(1));
                System.out.print("\t" + res.getString(2));
                System.out.print("\t" + res.getString(3));
                System.out.println("\t" + res.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void  CompareWithDatabase(String username,String userrole,String employeename,String status) {


        String dbUsername="", dbUserrole="", dbEmpName="", dbStatus = "";
        try {
            setUp();
            String query = "select * from users";
            // Get the contents of userinfo table from DB
            ResultSet res = stmt.executeQuery(query);
            // Print the result untill all the records are printed
            // res.next() returns true if there is any next record else returns false
            while (res.next()) {
                dbUsername = res.getString(1);
                dbUserrole = res.getString(2);
                dbEmpName = res.getString(3);
                dbStatus = res.getString(4);
                if (dbUsername.equals(username)) {
                   Assert.assertEquals(username, dbUsername);
                    Assert.assertEquals(userrole, dbUserrole);
                    Assert.assertEquals(employeename, dbEmpName);
                    Assert.assertEquals(status, dbStatus);

                    System.out.println("Database Values are");
                    System.out.print(res.getString(1));
                    System.out.print("\t" + res.getString(2));
                    System.out.print("\t" + res.getString(3));
                    System.out.println("\t" + res.getString(4));

                    System.out.println("\n UI Values are ");
                    System.out.print(username);
                    System.out.print("\t" + userrole);
                    System.out.print("\t" + employeename);
                    System.out.println("\t" + status);
                }
            }
        } catch (Exception e) {
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
