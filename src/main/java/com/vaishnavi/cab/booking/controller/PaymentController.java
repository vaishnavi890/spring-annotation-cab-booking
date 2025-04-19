package com.vaishnavi.cab.booking.controller;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    private final Scanner scanner = new Scanner(System.in);

    public void paymentMenu() {
        int choice;

        do {
            System.out.println("\n--- PAYMENT MANAGEMENT ---");
            System.out.println("1. Make Payment");
            System.out.println("2. Show All Payments");
            System.out.println("3. Update Payment");
            System.out.println("4. Delete Payment");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    makePayment();
                    break;
                case 2:
                    listPayments();
                    break;
                case 3:
                    updatePayment();
                    break;
                case 4:
                    deletePayment();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }

        } while (choice != 0);
    }

    private void makePayment() {
        System.out.print("Enter Payment ID: ");
        int paymentId = scanner.nextInt();
        System.out.print("Enter Ride ID: ");
        int rideId = scanner.nextInt();
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Payment Method: ");
        String method = scanner.nextLine();
        System.out.print("Enter Status: ");
        String status = scanner.nextLine();

        Payment payment = new Payment(paymentId, rideId, userId, amount, method, status);
        paymentService.makePayment(payment);
    }

    private void listPayments() {
        List<Payment> payments = paymentService.fetchAllPayments();
        if (payments.isEmpty()) {
            System.out.println(" No payments found.");
        } else {
            payments.forEach(System.out::println);
        }
    }

    private void updatePayment() {
        System.out.print("Enter Payment ID to Update: ");
        int paymentId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Updated Status: ");
        String status = scanner.nextLine();
        paymentService.updatePaymentStatus(paymentId, status);
    }

    private void deletePayment() {
        System.out.print("Enter Payment ID to Delete: ");
        int paymentId = scanner.nextInt();
        scanner.nextLine();
        paymentService.removePayment(paymentId);
    }
}


