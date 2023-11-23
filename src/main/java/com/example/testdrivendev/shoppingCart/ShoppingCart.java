package com.example.testdrivendev.shoppingCart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;
    private boolean checkedOut;
    private String selectedPaymentMethod;
    private boolean paid;

    public ShoppingCart() {
        products = new ArrayList<>();
        checkedOut = false;
        selectedPaymentMethod = null;
        paid = false;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public boolean containsProduct(Product product) {
        return products.contains(product);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : products) {
            totalPrice += product.getPrice() * product.getQuantity();
        }
        return totalPrice;
    }

    public int countProducts() {
        return products.size();
    }

    public void checkout() {
        checkedOut = true;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void selectPaymentMethod(String paymentMethod) {
        selectedPaymentMethod = paymentMethod;
    }

    public String getSelectedPaymentMethod() {
        return selectedPaymentMethod;
    }

    public void makePayment() {
        paid = true;
    }

    public boolean isPaid() {
        return paid;
    }

    public void applyDiscount(double discountPercentage) {
        double discountFactor = 1.0 - (discountPercentage / 100.0);
        for (Product product : products) {
            double discountedPrice = product.getPrice() * discountFactor;
            product.setPrice(discountedPrice);
        }
    }
}