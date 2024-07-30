package com.adapterpatternexample;

public class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;
    private String token;

    public StripeAdapter(String token) {
        this.stripeGateway = new StripeGateway();
        this.token = token;
    }

    @Override
    public boolean processPayment(double amount) {
        String chargeId = stripeGateway.charge(amount, token);
        return chargeId != null && !chargeId.isEmpty();
    }
}
