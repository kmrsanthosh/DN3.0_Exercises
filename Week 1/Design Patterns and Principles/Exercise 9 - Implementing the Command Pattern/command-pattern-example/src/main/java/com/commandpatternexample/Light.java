package com.commandpatternexample;

public class Light {
    private boolean isOn = false;

    public void turnOn() {
        isOn = true;
        System.out.println("Light is turned on");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Light is turned off");
    }
}