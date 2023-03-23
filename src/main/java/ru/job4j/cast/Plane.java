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
