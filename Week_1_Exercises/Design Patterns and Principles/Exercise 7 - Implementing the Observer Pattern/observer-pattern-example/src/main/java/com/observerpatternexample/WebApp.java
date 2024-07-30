package com.observerpatternexample;

public class WebApp implements Observer {
    private String name;

    public WebApp(String name) {
        this.name = name;
    }

    @Override
    public void update(double stockPrice) {
        System.out.println(name + " Web App - Stock price updated: $" + stockPrice);
    }
}
