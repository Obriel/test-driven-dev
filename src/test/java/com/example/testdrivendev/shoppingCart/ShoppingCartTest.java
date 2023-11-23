package com.example.testdrivendev.shoppingCart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    private ShoppingCart shoppingCart;

    @BeforeEach
    public void setUp() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void testAddProductToCart() {
        shoppingCart = new ShoppingCart();
        // Red: Write a failing test
        assertFalse(shoppingCart.containsProduct(new Product(1, "Product A", 10.0, 1)));

        // Green: Implement minimum code to pass the test
        shoppingCart.addProduct(new Product(1, "Product A", 10.0, 1));

        // Refactor: No changes needed in this case

        // Verify the product is added to the cart
        assertTrue(shoppingCart.containsProduct(new Product(1, "Product A", 10.0, 1)));
    }

    @Test
    public void testRemoveProductFromCart() {
        shoppingCart = new ShoppingCart();
        // Add a product to the cart for testing
        shoppingCart.addProduct(new Product(2, "Product B", 15.0, 1));

        // Red: Write a failing test
        assertTrue(shoppingCart.containsProduct(new Product(2, "Product B", 15.0, 1)));

        // Green: Implement minimum code to pass the test
        shoppingCart.removeProduct(new Product(2, "Product B", 15.0, 1));

        // Refactor: No changes needed in this case

        // Verify the product is removed from the cart
        assertFalse(shoppingCart.containsProduct(new Product(2, "Product B", 15.0, 1)));
    }

    @Test
    public void testCalculateTotalPrice() {
        shoppingCart = new ShoppingCart();
        // Add products to the cart for testing
        shoppingCart.addProduct(new Product(3, "Product C", 10.0, 2));
        shoppingCart.addProduct(new Product(4, "Product D", 15.0, 1));

        // Red: Write a failing test
        assertEquals(35.0, shoppingCart.calculateTotalPrice());

        // Green: Implement minimum code to pass the test

        // Refactor: No changes needed in this case

        // Verify the total price is calculated correctly
        assertEquals(35.0, shoppingCart.calculateTotalPrice());
    }

    @Test
    public void testCountProductsInCart() {
        shoppingCart = new ShoppingCart();
        // Add products to the cart for testing
        shoppingCart.addProduct(new Product(5, "Product E", 5.0, 1));
        shoppingCart.addProduct(new Product(6, "Product F", 7.5, 1));
        shoppingCart.addProduct(new Product(7, "Product G", 12.0, 1));

        // Red: Write a failing test
        assertEquals(3, shoppingCart.countProducts());

        // Green: Implement minimum code to pass the test

        // Refactor: No changes needed in this case

        // Verify the correct count of products in the cart
        assertEquals(3, shoppingCart.countProducts());
    }

    @Test
    public void testCheckout() {
        shoppingCart = new ShoppingCart();
        // Add products to the cart for testing
        shoppingCart.addProduct(new Product(8, "Product H", 20.0, 1));
        shoppingCart.addProduct(new Product(9, "Product I", 30.0, 1));

        // Red: Write a failing test
        assertFalse(shoppingCart.isCheckedOut());

        // Green: Implement minimum code to pass the test
        shoppingCart.checkout();

        // Refactor: No changes needed in this case

        // Verify that checkout is successful and cart is checked out
        assertTrue(shoppingCart.isCheckedOut());
    }

    @Test
    public void testSelectPaymentMethod() {
        shoppingCart = new ShoppingCart();
        // Add products to the cart for testing
        shoppingCart.addProduct(new Product(10, "Product J", 25.0, 1));

        // Red: Write a failing test
        assertNull(shoppingCart.getSelectedPaymentMethod());

        // Green: Implement minimum code to pass the test
        shoppingCart.selectPaymentMethod("Credit Card");

        // Refactor: No changes needed in this case

        // Verify that payment method is selected successfully
        assertEquals("Credit Card", shoppingCart.getSelectedPaymentMethod());
    }

    @Test
    public void testMakePayment() {
        shoppingCart = new ShoppingCart();
        // Add products to the cart for testing
        shoppingCart.addProduct(new Product(11, "Product K", 40.0, 1));

        // Select payment method for testing
        shoppingCart.selectPaymentMethod("PayPal");

        // Red: Write a failing test
        assertFalse(shoppingCart.isPaid());

        // Green: Implement minimum code to pass the test
        shoppingCart.makePayment();

        // Refactor: No changes needed in this case

        // Verify that payment is made successfully and cart is paid
        assertTrue(shoppingCart.isPaid());
    }

    @Test
    public void testApplyDiscount() {
        shoppingCart = new ShoppingCart();
        // Add products to the cart for testing
        shoppingCart.addProduct(new Product(12, "Product L", 50.0, 1));

        // Select payment method for testing
        shoppingCart.selectPaymentMethod("Credit Card");

        // Red: Write a failing test
        assertEquals(50.0, shoppingCart.calculateTotalPrice());

        // Green: Implement minimum code to pass the test
        shoppingCart.applyDiscount(10);

        // Refactor: No changes needed in this case

        // Verify that discount is applied successfully and total price is updated accordingly
        assertEquals(45.0, shoppingCart.calculateTotalPrice());
    }

}

