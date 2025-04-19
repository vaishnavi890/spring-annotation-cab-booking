package com.vaishnavi.cab.booking.service;

import com.vaishnavi.cab.booking.model.Payment;
import com.vaishnavi.cab.booking.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public void processPayment(Payment payment) {
        if (payment != null && payment.getPaymentId() > 0) {
            paymentRepository.addPayment(payment);
        } else {
            System.out.println(" Invalid Payment Details. Cannot Process.");
        }
    }

    public List<Payment> fetchAllPayments() {
        return paymentRepository.getAllPayments();
    }

    public void updatePayment(Payment payment) {
        if (payment != null && payment.getPaymentId() > 0) {
            paymentRepository.updatePayment(payment);
        } else {
            System.out.println("Invalid Payment Details. Cannot Update.");
        }
    }

    public void deletePayment(int paymentId) {
        if (paymentId > 0) {
            paymentRepository.deletePayment(paymentId);
        } else {
            System.out.println("Invalid Payment ID. Cannot Delete.");
        }
    }

    public void removePayment(int paymentId) {
    }

    public void modifyPayment(Payment payment) {
    }

    public void makePayment(Payment payment) {
    }

    public void updatePaymentStatus(int paymentId, String status) {
    }
}



