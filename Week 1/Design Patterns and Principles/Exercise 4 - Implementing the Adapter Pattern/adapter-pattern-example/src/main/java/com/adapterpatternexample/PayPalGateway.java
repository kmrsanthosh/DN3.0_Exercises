package com.adapterpatternexample;

public class PayPalGateway {
    public boolean makePayment(String email, double amount) {
        System.out.println("Processing PayPal payment of $" + amount + " for " + email);
        return true;
    }
}
