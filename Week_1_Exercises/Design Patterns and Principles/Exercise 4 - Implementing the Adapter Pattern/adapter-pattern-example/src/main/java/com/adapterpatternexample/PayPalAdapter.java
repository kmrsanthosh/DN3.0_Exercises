package com.adapterpatternexample;

public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;
    private String email;

    public PayPalAdapter(String email) {
        this.payPalGateway = new PayPalGateway();
        this.email = email;
    }

    @Override
    public boolean processPayment(double amount) {
        return payPalGateway.makePayment(email, amount);
    }
}
