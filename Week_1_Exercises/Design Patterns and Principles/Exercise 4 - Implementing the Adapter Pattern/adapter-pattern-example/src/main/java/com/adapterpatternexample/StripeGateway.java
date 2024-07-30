package com.adapterpatternexample;

public class StripeGateway {
    public String charge(double amount, String token) {
        System.out.println("Charging $" + amount + " using Stripe with token: " + token);
        return "CH_" + Math.random();
    }
}
