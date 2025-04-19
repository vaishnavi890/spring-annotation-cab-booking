package com.vaishnavi.cab.booking;

import com.vaishnavi.cab.booking.config.AppConfig;
import com.vaishnavi.cab.booking.controller.UserController;
import com.vaishnavi.cab.booking.controller.DriverController;
import com.vaishnavi.cab.booking.controller.RideController;
import com.vaishnavi.cab.booking.controller.PaymentController;
import com.vaishnavi.cab.booking.controller.RatingController;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class CabBooking {

    public static void main(String[] args) {

        // Load Spring context using annotation-based configuration
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get all controller beans from Spring container
        UserController userController = context.getBean(UserController.class);
        DriverController driverController = context.getBean(DriverController.class);
        RideController rideController = context.getBean(RideController.class);
        PaymentController paymentController = context.getBean(PaymentController.class);
        RatingController ratingController = context.getBean(RatingController.class);

        Scanner scanner = new Scanner(System.in);
        int choice;

        // Main application menu
        do {
            System.out.println("\n======= CAB ORDER MANAGEMENT SYSTEM =======");
            System.out.println("1. Manage Users");
            System.out.println("2. Manage Drivers");
            System.out.println("3. Manage Rides");
            System.out.println("4. Manage Payments");
            System.out.println("5. Manage Ratings");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // discard invalid input
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    userController.userMenu();
                    break;
                case 2:
                    driverController.driverMenu();
                    break;
                case 3:
                    rideController.rideMenu();
                    break;
                case 4:
                    paymentController.paymentMenu();
                    break;
                case 5:
                    ratingController.ratingMenu();
                    break;
                case 0:
                    System.out.println("Thank you for using the Cab Order Management System. Goodbye!");
                    break;
                default:
                    System.out.println(" Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}



