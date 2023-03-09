package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        System.out.println(sum(10));
        System.out.println(minus(5));
        Calculator calc = new Calculator();
        System.out.println(calc.multiply(5));
        System.out.println(calc.divide(2));
        System.out.println(calc.sumAllOperation(10));
    }
}