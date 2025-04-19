package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.connection.DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DriverRepository {

    public void addDriver(Driver driver) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO drivers (driver_id, name, email, phone, cab_details) VALUES (?, ?, ?, ?, ?)")) {

            pstmt.setInt(1, driver.getDriverId());
            pstmt.setString(2, driver.getName());
            pstmt.setString(3, driver.getEmail());
            pstmt.setString(4, driver.getPhone());
            pstmt.setString(5, driver.getCabDetails());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Driver> getAllDrivers() {
        List<Driver> drivers = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM drivers")) {

            while (rs.next()) {
                drivers.add(new Driver(
                        rs.getInt("driver_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("cab_details")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drivers;
    }

    public void updateDriver(Driver driver) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "UPDATE drivers SET name = ?, email = ?, phone = ?, cab_details = ? WHERE driver_id = ?")) {

            pstmt.setString(1, driver.getName());
            pstmt.setString(2, driver.getEmail());
            pstmt.setString(3, driver.getPhone());
            pstmt.setString(4, driver.getCabDetails());
            pstmt.setInt(5, driver.getDriverId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDriver(int driverId) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM drivers WHERE driver_id = ?")) {

            pstmt.setInt(1, driverId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
