package com.vaishnavi.cab.booking.repository;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.connection.DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RatingRepository {

    public void addRating(Rating rating) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO ratings (rating_id, ride_id, user_id, driver_id, rating, review) VALUES (?, ?, ?, ?, ?, ?)")) {

            pstmt.setInt(1, rating.getRatingId());
            pstmt.setInt(2, rating.getRideId());
            pstmt.setInt(3, rating.getUserId());
            pstmt.setInt(4, rating.getDriverId());
            pstmt.setInt(5, rating.getRating());
            pstmt.setString(6, rating.getReview());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Rating> getAllRatings() {
        List<Rating> ratings = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM ratings")) {

            while (rs.next()) {
                ratings.add(new Rating(
                        rs.getInt("rating_id"),
                        rs.getInt("ride_id"),
                        rs.getInt("user_id"),
                        rs.getInt("driver_id"),
                        rs.getInt("rating"),
                        rs.getString("review")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ratings;
    }

    public void updateRating(Rating rating) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "UPDATE ratings SET rating = ?, review = ? WHERE rating_id = ?")) {

            pstmt.setInt(1, rating.getRating());
            pstmt.setString(2, rating.getReview());
            pstmt.setInt(3, rating.getRatingId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRating(int ratingId) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ratings WHERE rating_id = ?")) {

            pstmt.setInt(1, ratingId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



