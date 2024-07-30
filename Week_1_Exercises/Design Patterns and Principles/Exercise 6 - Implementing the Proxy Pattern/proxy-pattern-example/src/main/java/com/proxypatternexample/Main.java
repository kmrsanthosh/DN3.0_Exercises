package com.proxypatternexample;

public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        System.out.println("First time display of image1:");
        image1.display();
        System.out.println();

        System.out.println("Second time display of image1:");
        image1.display();
        System.out.println();

        System.out.println("First time display of image2:");
        image2.display();
    }
}