package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printError() {
        System.out.println("Error is active: " + active);
        System.out.println("Status is: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printError();
        Error error400 = new Error(true, 400, "bad request");
        error400.printError();
        Error error401 = new Error(true, 401, "unauthorized");
        error401.printError();
    }
}
