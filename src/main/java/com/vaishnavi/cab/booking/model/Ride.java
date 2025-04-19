package com.vaishnavi.cab.booking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Ride {
    private int rideId;
    private int userId;
    private int driverId;
    private String pickupLocation;
    private String dropoffLocation;
    private double fare;
    private String status;

    public Ride(int rideId, int userId, int driverId, String pickupLocation, String dropoffLocation, double fare, String status) {
    }

    public int getRideId() {
        return 0;
    }

    public int getUserId() {
        return 0;
    }

    public int getDriverId() {
        return 0;
    }

    public String getPickupLocation() {
        return "";
    }

    public String getDropoffLocation() {
        return "";
    }

    public double getFare() {
        return 0;
    }

    public String getStatus() {
        return "";
    }
}



