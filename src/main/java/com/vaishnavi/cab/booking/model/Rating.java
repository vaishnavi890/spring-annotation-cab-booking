package com.vaishnavi.cab.booking.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rating {
    private int ratingId;
    private int rideId;
    private int userId;
    private int driverId;
    private int rating;
    private String review;

    public Rating(int ratingId, int rideId, int userId, int driverId, int rating, String review) {
    }

    public int getRatingId() {
        return ratingId;
    }

    public int getRideId() {
        return rideId;
    }

    public int getUserId() {
        return userId;
    }

    public int getDriverId() {
        return driverId;
    }

    public int getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }
}




