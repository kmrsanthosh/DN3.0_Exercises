package com.builderpatternexample;

public class Computer {
    private String CPU;
    private int RAM;
    private int storage;
    private String graphicsCard;
    private String operatingSystem;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.operatingSystem = builder.operatingSystem;
    }

    public String getCPU() {
        return CPU;
    }

    public int getRAM() {
        return RAM;
    }

    public int getStorage() {
        return storage;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", RAM=" + RAM +
                ", storage=" + storage +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                '}';
    }

    public static class Builder {
        private String CPU;
        private int RAM;
        private int storage;
        private String graphicsCard;
        private String operatingSystem;

        public Builder(String CPU) {
            this.CPU = CPU;
        }

        public Builder setRAM(int RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setOperatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
