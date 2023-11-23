package com.example.testdrivendev.paymentProcessing;

import lombok.Data;

@Data
public class Payment {

    private Long id;
    private String sourceMobileNumber;
    private String merchantNumber;
    private String merchantCode;
    private double amount;
    private String sourceReference;
}

