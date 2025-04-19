package com.vaishnavi.cab.booking.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/cab_order_db"; // Change DB name
    private static final String USER = "root"; // DB username
    private static final String PASSWORD = "password"; // DB password

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        int retryCount = 0;
        do {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✅ Connected to the database.");
                break;
            } catch (SQLException e) {
                System.out.println(" Connection failed. Retrying...");
                retryCount++;
                if (retryCount >= 3) {
                    throw e;
                }
                try {
                    Thread.sleep(2000); // Wait before retry
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        } while (connection == null && retryCount < 3);
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println(" Connection closed.");
            }
        } catch (SQLException e) {
            System.out.println(" Failed to close connection.");
            e.printStackTrace();
        }
    }
}



