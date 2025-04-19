package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Rating;
import com.vaishnavi.cab.booking.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class RatingController {

    @Autowired
    private RatingService ratingService;

    private final Scanner scanner = new Scanner(System.in);

    public void ratingMenu() {
        int choice;

        do {
            System.out.println("\n--- RATING MANAGEMENT ---");
            System.out.println("1. Add Rating");
            System.out.println("2. Show All Ratings");
            System.out.println("3. Update Rating");
            System.out.println("4. Delete Rating");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addRating();
                    break;
                case 2:
                    listRatings();
                    break;
                case 3:
                    updateRating();
                    break;
                case 4:
                    deleteRating();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }

        } while (choice != 0);
    }

    private void addRating() {
        System.out.print("Enter Rating ID: ");
        int ratingId = scanner.nextInt();
        System.out.print("Enter Ride ID: ");
        int rideId = scanner.nextInt();
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter Driver ID: ");
        int driverId = scanner.nextInt();
        System.out.print("Enter Rating (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Review: ");
        String review = scanner.nextLine();

        Rating rate = new Rating(ratingId, rideId, userId, driverId, rating, review);
        ratingService.addRating(rate);
    }

    private void listRatings() {
        List<Rating> ratings = ratingService.fetchAllRatings();
        if (ratings.isEmpty()) {
            System.out.println(" No ratings found.");
        } else {
            ratings.forEach(System.out::println);
        }
    }

    private void updateRating() {
        System.out.print("Enter Rating ID to Update: ");
        int ratingId = scanner.nextInt();
        System.out.print("Enter New Rating (1-5): ");
        int newRating = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Updated Review: ");
        String review = scanner.nextLine();

        ratingService.updateRating(ratingId, newRating, review);
    }

    private void deleteRating() {
        System.out.print("Enter Rating ID to Delete: ");
        int ratingId = scanner.nextInt();
        scanner.nextLine();
        ratingService.removeRating(ratingId);
    }
}



