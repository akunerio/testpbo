/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package utils;

import java.sql.*;

/**
 *
 * @author luliou
 */
public class JDBC {

    private Connection con;
    private Statement stmt;
    private boolean isConnected;
    private String message;

    public void connect() {
        String dbname = "testpbo";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + dbname, username, password);
            stmt = con.createStatement();
            isConnected = true;
            message = "DB connected";
        } catch (Exception e) {
            isConnected = false;
            message = e.getMessage();
        }
    }

    private void disconnect() {
        try {
            stmt.close();
            con.close();
        } catch (Exception e) {
            message = e.getMessage();
        }
    }

    public void runQuery(String query) {
        try {
            connect();
            int result = stmt.executeUpdate(query);
            message = "info: " + result + " rows affected";
        } catch (Exception e) {
            message = e.getMessage();
        } finally {
            disconnect();
        }
    }

    public String getMessage() {
        return message;
    }

    public ResultSet getData(String query) {
        ResultSet rs = null;
        try {
            connect();
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            message = e.getMessage();
        }
        return rs;
    }

  
}
