package ru.job4j.stream;

import org.testng.ISuite;
import ru.job4j.stream.Suit;
import ru.job4j.stream.Value;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                    .map(value -> value + " " + suit))
                .forEach(System.out::println);

    }
}