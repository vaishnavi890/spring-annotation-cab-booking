package com.vaishnavi.cab.booking.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Driver {
    private int driverId;
    private String name;
    private String email;
    private String phone;
    private String cabDetails;

    public Driver(int driverId, String name, String email, String phone, String cabDetails) {
    }

    public int getDriverId() {
        return 0;
    }

    public String getName() {
        return "";
    }

    public String getEmail() {
        return "";
    }

    public String getPhone() {
        return "";
    }

    public String getCabDetails() {
        return "";
    }
}



