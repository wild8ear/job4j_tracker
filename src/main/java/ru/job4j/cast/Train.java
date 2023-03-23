package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Передвижается по рельсам");
    }

    @Override
    public void stop() {
        System.out.println("Имеет стоп-кран");
    }
}
