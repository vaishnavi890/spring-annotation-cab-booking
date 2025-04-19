package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Driver;
import com.vaishnavi.cab.booking.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class DriverController {

    @Autowired
    private DriverService driverService;

    private final Scanner scanner = new Scanner(System.in);

    public void driverMenu() {
        int choice;

        do {
            System.out.println("\n--- DRIVER MANAGEMENT ---");
            System.out.println("1. Add Driver");
            System.out.println("2. Show All Drivers");
            System.out.println("3. Update Driver");
            System.out.println("4. Delete Driver");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addDriver();
                    break;
                case 2:
                    listDrivers();
                    break;
                case 3:
                    updateDriver();
                    break;
                case 4:
                    deleteDriver();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }

        } while (choice != 0);
    }

    private void addDriver() {
        System.out.print("Enter Driver ID: ");
        int driverId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Cab Details: ");
        String cabDetails = scanner.nextLine();

        Driver driver = new Driver(driverId, name, email, phone, cabDetails);
        driverService.registerDriver(driver);
    }

    private void listDrivers() {
        List<Driver> drivers = driverService.fetchAllDrivers();
        if (drivers.isEmpty()) {
            System.out.println("❌ No drivers found.");
        } else {
            drivers.forEach(System.out::println);
        }
    }

    private void updateDriver() {
        System.out.print("Enter Driver ID to Update: ");
        int driverId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Updated Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Updated Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Updated Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Updated Cab Details: ");
        String cabDetails = scanner.nextLine();

        Driver driver = new Driver(driverId, name, email, phone, cabDetails);
        driverService.modifyDriver(driver);
    }

    private void deleteDriver() {
        System.out.print("Enter Driver ID to Delete: ");
        int driverId = scanner.nextInt();
        scanner.nextLine();
        driverService.removeDriver(driverId);
    }
}

