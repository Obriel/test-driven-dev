package com.example.testdrivendev.paymentProcessing;

import com.example.testdrivendev.paymentProcessing.Payment;
import com.example.testdrivendev.paymentProcessing.PaymentService;
import com.example.testdrivendev.paymentProcessing.PaymentStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class PaymentProcessingSystemTest {

    private PaymentService paymentService;

    @BeforeEach
    public void setUp() {
        List<Payment> paymentList = new ArrayList<>();
        paymentService = new PaymentService(paymentList);
    }

    @Test
    public void test_Process_Valid_Payment() {
        // Arrange
        Payment payment = new Payment();
        payment.setId(1L);
        payment.setSourceMobileNumber("777222606");
        payment.setMerchantNumber("772222609");
        payment.setSourceReference("Test1234");
        payment.setAmount(50.0);

        // Act
        boolean result = paymentService.processPayment(payment);

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void test_Process_Invalid_Payment() {
        // Arrange
        Payment payment = new Payment();
        payment.setId(1L);
        payment.setSourceMobileNumber("777222606");
        payment.setMerchantNumber("772222609");
        payment.setSourceReference("Test1234");
        payment.setAmount(-50.0);

        // Act
        boolean result = paymentService.processPayment(payment);

        // Assert
        Assertions.assertFalse(result);
    }

    @Test
    public void test_Payment_Status() {
        // Arrange
        Payment payment = new Payment();
        payment.setId(1L);
        payment.setSourceMobileNumber("777222606");
        payment.setMerchantNumber("772222609");
        payment.setSourceReference("Test1234");
        payment.setAmount(100.0);
        paymentService.processPayment(payment);

        // Act
        PaymentStatus status = paymentService.getPaymentStatus(payment.getId());

        // Assert
        Assertions.assertEquals(PaymentStatus.SUCCESSFUL, status);
    }

    @Test
    public void test_Refund_Payment() {
        // Arrange
        Payment payment = new Payment();
        payment.setId(1L);
        payment.setSourceMobileNumber("777222606");
        payment.setMerchantNumber("772222609");
        payment.setSourceReference("Test1234");
        payment.setAmount(50.0);
        paymentService.processPayment(payment);

        // Act
        boolean result = paymentService.refundPayment(payment.getId());

        // Assert
        Assertions.assertTrue(result);
        Assertions.assertEquals(0.0, payment.getAmount());
    }
}

