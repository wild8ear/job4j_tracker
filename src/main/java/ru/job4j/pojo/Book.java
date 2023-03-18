package ru.job4j.pojo;

public class Book {

    private String name;
    private int countOfPages;

    public Book(String name, int countOfPages) {
        this.name = name;
        this.countOfPages = countOfPages;
    }

    public String getName() {
        return name;
    }

    public int getCountOfPages() {
        return countOfPages;
    }
}
