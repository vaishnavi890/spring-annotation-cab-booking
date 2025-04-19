package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.User;
import com.vaishnavi.cab.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class UserController {

    @Autowired
    private UserService userService;

    private final Scanner scanner = new Scanner(System.in);

    public void userMenu() {
        int choice;

        do {
            System.out.println("\n--- USER MANAGEMENT ---");
            System.out.println("1. Register User");
            System.out.println("2. Show All Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    listUsers();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }

        } while (choice != 0);
    }

    private void registerUser() {
        System.out.println("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Email: ");
        String email = scanner.nextLine();
        System.out.println("Enter Phone: ");
        String phone = scanner.nextLine();

        User user = new User(userId, name, email, phone);
        userService.registerUser(user);
    }

    private void listUsers() {
        List<User> users = userService.fetchAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            users.forEach(System.out::println);
        }
    }

    private void updateUser() {
        System.out.println("Enter User ID to Update: ");
        int userId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Updated Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Updated Email: ");
        String email = scanner.nextLine();
        System.out.println("Enter Updated Phone: ");
        String phone = scanner.nextLine();

        User user = new User(userId, name, email, phone);
        userService.modifyUser(user);
    }

    private void deleteUser() {
        System.out.println("Enter User ID to Delete: ");
        int userId = scanner.nextInt();
        scanner.nextLine();
        userService.removeUser(userId);
    }
}
