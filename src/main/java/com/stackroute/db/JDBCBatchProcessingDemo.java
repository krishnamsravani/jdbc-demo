package com.stackroute.db;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class JDBCBatchProcessingDemo {
    public void jdbcBatchProcessing() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "Root@123");

            PreparedStatement ps = con.prepareStatement("insert into customerdetails values(?,?,?,?)");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {

                System.out.println("enter id");
                String s1 = br.readLine();
                int id = Integer.parseInt(s1);

                System.out.println("enter name");
                String name = br.readLine();

                System.out.println("enter age");
                String s3 = br.readLine();
                int age = Integer.parseInt(s3);

                System.out.println("enter gender");
                String gender = br.readLine();

                ps.setInt(1, id);

                ps.setString(2, name);
                ps.setInt(3, age);
                ps.setString(4, gender);


                ps.addBatch();
                System.out.println("Want to add more records y/n");
                String ans = br.readLine();
                if (ans.equals("n")) {
                    break;
                }

            }
            ps.executeBatch();

            System.out.println("record successfully saved");


            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from customerdetails");
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getInt(3));

            con.close();


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
