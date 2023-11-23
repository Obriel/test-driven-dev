package com.example.testdrivendev.paymentProcessing;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private List<Payment> paymentList;

    public PaymentService(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public boolean processPayment(Payment payment) {
        // Logic for processing payment
        // Return true if payment is successful, false otherwise

        // Save the payment record in the list
        paymentList.add(payment);

        return true; // Placeholder return value
    }

    public PaymentStatus getPaymentStatus(Long paymentId) {
        // Logic for retrieving payment status
        // Return the payment status enum value

        // Find the payment record in the list
        Payment payment = findPaymentById(paymentId);

        if (payment != null) {
            // Implement your logic to determine the payment status based on the payment record
            // Return the appropriate PaymentStatus enum value
            return PaymentStatus.SUCCESSFUL;
        }

        return PaymentStatus.FAILED; // Placeholder return value
    }

    public boolean refundPayment(Long paymentId) {
        // Find the payment record in the list
        Payment payment = findPaymentById(paymentId);

        if (payment != null) {
            // Implement your logic to perform the refund process
            // For example, deduct the amount from the payment
            payment.setAmount(0.0);

            // Return true to indicate a successful refund
            return true;
        }

        // Return false if the payment record is not found
        return false;
    }

    private Payment findPaymentById(Long paymentId) {
        // Implement your logic to find the payment record in the list based on the paymentId
        // Return the Payment object if found, null otherwise

        for (Payment payment : paymentList) {
            if (payment.getId().equals(paymentId)) {
                return payment;
            }
        }

        return null; // Placeholder return value
    }
}

