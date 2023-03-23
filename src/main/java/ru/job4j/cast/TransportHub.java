package ru.job4j.cast;

public class TransportHub {
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
