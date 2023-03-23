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

    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle bus = new Bus();
        Vehicle train = new Train();

        Vehicle[] transports = {plane, bus, train};

        for (Vehicle transport : transports) {
            transport.move();
            transport.stop();
        }
    }
}
