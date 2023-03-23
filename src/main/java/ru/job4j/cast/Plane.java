package ru.job4j.cast;

public class Plane implements Vehicle {

    @Override
    public void move() {
        System.out.println("Летает в воздухе");
    }

    @Override
    public void stop() {
        System.out.println("Не может применить резкое торможение");
    }
}
