package com.strategypatternexample;

public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        System.out.println("Customer is paying using Credit Card...");
        context.setPaymentStrategy(new CreditCardPayment("John Doe", "1234567890123456", "786", "12/2025"));
        context.executePayment(100.50);

        System.out.println("\nCustomer is paying using PayPal...");
        context.setPaymentStrategy(new PayPalPayment("johndoe@example.com", "password123"));
        context.executePayment(75.25);
    }
}