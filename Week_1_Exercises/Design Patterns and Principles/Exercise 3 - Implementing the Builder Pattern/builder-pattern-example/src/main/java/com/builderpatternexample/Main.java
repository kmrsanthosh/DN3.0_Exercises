package com.builderpatternexample;

public class Main {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("Intel i3")
                .setRAM(8)
                .setStorage(256)
                .build();

        Computer gamingComputer = new Computer.Builder("AMD Ryzen 7")
                .setRAM(32)
                .setStorage(1000)
                .setGraphicsCard("NVIDIA RTX 3080")
                .setOperatingSystem("Windows 10")
                .build();

        System.out.println("Basic Computer: " + basicComputer);
        System.out.println("Gaming Computer: " + gamingComputer);
    }
}