package ru.job4j.oop;

public abstract class Vehicle {
    private String brand;
    private String model;
    private String type;
    private int passengers;
    private int maxSpeed;

    public abstract void accelerate();

    public abstract void steer();

    public void brake() {
        System.out.println("Стандартная тормозная система");
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public int getPassengers() {
        return passengers;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
