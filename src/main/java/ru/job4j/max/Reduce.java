package ru.job4j.max;

public class Reduce {
    private int[] arrayOfNumbers;

    public void to(int[] array) {
        arrayOfNumbers = array;
    }

    public void print() {
        for (int number : arrayOfNumbers) {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(array);
        reduce.print();
    }
}