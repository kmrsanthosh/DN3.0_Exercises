package com.adapterpatternexample;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor payPalProcessor = new PayPalAdapter("user@example.com");
        testPayment(payPalProcessor, 100.00);

        PaymentProcessor stripeProcessor = new StripeAdapter("tok_visa");
        testPayment(stripeProcessor, 200.00);
    }

    private static void testPayment(PaymentProcessor processor, double amount) {
        boolean result = processor.processPayment(amount);
        System.out.println("Payment " + (result ? "successful" : "failed"));
        System.out.println();
    }
}