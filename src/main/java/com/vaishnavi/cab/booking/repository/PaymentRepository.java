package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.connection.DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {

    public void makePayment(Payment payment) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO payments (payment_id, ride_id, user_id, amount, payment_method, status) VALUES (?, ?, ?, ?, ?, ?)")) {

            pstmt.setInt(1, payment.getPaymentId());
            pstmt.setInt(2, payment.getRideId());
            pstmt.setInt(3, payment.getUserId());
            pstmt.setDouble(4, payment.getAmount());
            pstmt.setString(5, payment.getPaymentMethod());
            pstmt.setString(6, payment.getStatus());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM payments")) {

            while (rs.next()) {
                payments.add(new Payment(
                        rs.getInt("payment_id"),
                        rs.getInt("ride_id"),
                        rs.getInt("user_id"),
                        rs.getDouble("amount"),
                        rs.getString("payment_method"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }

    public void updatePayment(Payment payment) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "UPDATE payments SET amount = ?, payment_method = ?, status = ? WHERE payment_id = ?")) {

            pstmt.setDouble(1, payment.getAmount());
            pstmt.setString(2, payment.getPaymentMethod());
            pstmt.setString(3, payment.getStatus());
            pstmt.setInt(4, payment.getPaymentId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePayment(int paymentId) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM payments WHERE payment_id = ?")) {

            pstmt.setInt(1, paymentId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPayment(Payment payment) {
    }
}



