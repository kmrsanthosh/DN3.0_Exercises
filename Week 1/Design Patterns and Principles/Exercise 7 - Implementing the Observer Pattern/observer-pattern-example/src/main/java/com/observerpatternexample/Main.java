package com.observerpatternexample;

import java.util.Observer;

public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        MobileApp mobileApp1 = new MobileApp("Investor1");
        MobileApp mobileApp2 = new MobileApp("Investor2");
        WebApp webApp1 = new WebApp("Trader1");

        stockMarket.register(mobileApp1);
        stockMarket.register(mobileApp2);
        stockMarket.register(webApp1);

        System.out.println("Updating stock price to $100.50");
        stockMarket.setStockPrice(100.50);

        System.out.println("\nDeregistering Investor2 Mobile App");
        stockMarket.deregister(mobileApp2);

        System.out.println("\nUpdating stock price to $95.75");
        stockMarket.setStockPrice(95.75);
    }
}