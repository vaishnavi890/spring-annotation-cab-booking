package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Ride;
import com.vaishnavi.cab.booking.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class RideController {

    @Autowired
    private RideService rideService;

    private final Scanner scanner = new Scanner(System.in);

    public void rideMenu() {
        int choice;

        do {
            System.out.println("\n--- RIDE MANAGEMENT ---");
            System.out.println("1. Book Ride");
            System.out.println("2. Show All Rides");
            System.out.println("3. Update Ride Status");
            System.out.println("4. Cancel Ride");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    bookRide();
                    break;
                case 2:
                    listRides();
                    break;
                case 3:
                    updateRide();
                    break;
                case 4:
                    cancelRide();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }

        } while (choice != 0);
    }

    private void bookRide() {
        System.out.print("Enter Ride ID: ");
        int rideId = scanner.nextInt();
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter Driver ID: ");
        int driverId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Pickup Location: ");
        String pickup = scanner.nextLine();
        System.out.print("Enter Dropoff Location: ");
        String dropoff = scanner.nextLine();
        System.out.print("Enter Fare: ");
        double fare = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Status: ");
        String status = scanner.nextLine();

        Ride ride = new Ride(rideId, userId, driverId, pickup, dropoff, fare, status);
        rideService.bookRide(ride);
    }

    private void listRides() {
        List<Ride> rides = rideService.fetchAllRides();
        if (rides.isEmpty()) {
            System.out.println(" No rides found.");
        } else {
            rides.forEach(System.out::println);
        }
    }

    private void updateRide() {
        System.out.print("Enter Ride ID to Update: ");
        int rideId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Updated Status: ");
        String status = scanner.nextLine();
        rideService.updateRideStatus(rideId, status);
    }

    private void cancelRide() {
        System.out.print("Enter Ride ID to Cancel: ");
        int rideId = scanner.nextInt();
        scanner.nextLine();
        rideService.removeRide(rideId);
    }
}
