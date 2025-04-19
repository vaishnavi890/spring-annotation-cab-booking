package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.connection.DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RideRepository {

    public void bookRide(Ride ride) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO rides (ride_id, user_id, driver_id, pickup_location, dropoff_location, fare, status) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            pstmt.setInt(1, ride.getRideId());
            pstmt.setInt(2, ride.getUserId());
            pstmt.setInt(3, ride.getDriverId());
            pstmt.setString(4, ride.getPickupLocation());
            pstmt.setString(5, ride.getDropoffLocation());
            pstmt.setDouble(6, ride.getFare());
            pstmt.setString(7, ride.getStatus());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ride> getAllRides() {
        List<Ride> rides = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM rides")) {

            while (rs.next()) {
                rides.add(new Ride(
                        rs.getInt("ride_id"),
                        rs.getInt("user_id"),
                        rs.getInt("driver_id"),
                        rs.getString("pickup_location"),
                        rs.getString("dropoff_location"),
                        rs.getDouble("fare"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rides;
    }

    public void updateRide(Ride ride) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "UPDATE rides SET pickup_location = ?, dropoff_location = ?, fare = ?, status = ? WHERE ride_id = ?")) {

            pstmt.setString(1, ride.getPickupLocation());
            pstmt.setString(2, ride.getDropoffLocation());
            pstmt.setDouble(3, ride.getFare());
            pstmt.setString(4, ride.getStatus());
            pstmt.setInt(5, ride.getRideId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRide(int rideId) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM rides WHERE ride_id = ?")) {

            pstmt.setInt(1, rideId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addRide(Ride ride) {
    }
}


