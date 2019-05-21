package com.stackroute.db;

import java.sql.*;

public class ResultsetMetadataDemo
{

    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/customerdb","root","Root@123");;


        PreparedStatement ps = con.prepareStatement("select * from customer");
        ResultSet rs = null;

        {
            try {
                rs = ps.executeQuery("Select * from customer");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        ResultSetMetaData rsmd = null;

        {
            try {
                rsmd = rs.getMetaData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Total columns: " + rsmd.getColumnCount());
        try {
            System.out.println("Column Name of 1st column: " + rsmd.getColumnName(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Column Type Name of 1st column: " + rsmd.getColumnTypeName(1));
    }
}
