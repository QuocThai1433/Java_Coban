package com.example.demo.studentpk;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    static Connection conn = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/qlsv";
            String username = "root";
            String password = "1234";
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] arg) {
        if (getConnection() != null) {
            System.out.print("Connect Successful");
        } else {
            System.out.println("Connect fail!!");
        }
    }
}
