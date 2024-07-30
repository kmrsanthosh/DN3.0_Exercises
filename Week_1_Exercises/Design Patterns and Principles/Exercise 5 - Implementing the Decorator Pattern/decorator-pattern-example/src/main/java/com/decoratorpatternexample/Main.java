package com.decoratorpatternexample;

public class Main {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        System.out.println("Sending basic email notification:");
        emailNotifier.send("Hello, this is a test message!");
        System.out.println();

        Notifier emailSmsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        System.out.println("Sending email and SMS notification:");
        emailSmsNotifier.send("Hello, this is a test message!");
        System.out.println();

        Notifier emailSmsSlackNotifier = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        System.out.println("Sending email, SMS, and Slack notification:");
        emailSmsSlackNotifier.send("Hello, this is a test message!");
    }
}