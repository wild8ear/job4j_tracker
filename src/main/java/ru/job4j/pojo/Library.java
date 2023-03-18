package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 200);
        Book book2 = new Book("Dirty code", 199);
        Book book3 = new Book("Amazing code", 1000);
        Book book4 = new Book("Mad code", 10);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (Book book: books) {
            System.out.println("The book name is: " + book.getName()
                + " which has " + book.getCountOfPages() + " pages");
        }
        books[3] = book1;
        books[0] = book4;
        for (Book book: books) {
            System.out.println("The book name is: " + book.getName()
                    + " which has " + book.getCountOfPages() + " pages");
        }
        for (Book book: books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println("The book name is: " + book.getName()
                        + " which has " + book.getCountOfPages() + " pages");
            }
        }
    }
}
