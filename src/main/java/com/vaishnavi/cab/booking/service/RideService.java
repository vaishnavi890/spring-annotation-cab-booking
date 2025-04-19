package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideService {

    @Autowired
    private RideRepository rideRepository;

    public void bookRide(Ride ride) {
        if (ride != null && ride.getRideId() > 0) {
            rideRepository.addRide(ride);
        } else {
            System.out.println(" Invalid Ride Details. Cannot Book.");
        }
    }

    public List<Ride> fetchAllRides() {
        return rideRepository.getAllRides();
    }

    public void updateRide(Ride ride) {
        if (ride != null && ride.getRideId() > 0) {
            rideRepository.updateRide(ride);
        } else {
            System.out.println("Invalid Ride Details. Cannot Update.");
        }
    }

    public void cancelRide(int rideId) {
        if (rideId > 0) {
            rideRepository.deleteRide(rideId);
        } else {
            System.out.println(" Invalid Ride ID. Cannot Delete.");
        }
    }

    public void modifyRide(Ride ride) {
    }

    public void removeRide(int rideId) {
    }

    public void updateRideStatus(int rideId, String status) {
    }
}



