package ru.job4j.cast;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println("Передвигается по шоссе");
    }

    @Override
    public void stop() {
        System.out.println("Имеет ручной тормоз");
    }
}
