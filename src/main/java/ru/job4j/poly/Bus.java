package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Автобус поехал.");
    }

    @Override
    public void passengers(int numberOfPassengers) {
        System.out.println("Число пассажиров: " + numberOfPassengers);
    }

    @Override
    public int fueling(int countOfFuel) {
        return countOfFuel * 45;
    }

    public static void main(String[] args) {
        Transport bus = new Bus();
        bus.drive();
        bus.passengers(10);
        System.out.println("Стоимость бензина " + bus.fueling(15));
    }
}
