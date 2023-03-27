package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UsagePackageDate {

    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        LocalDateTime currentDateTime = LocalDateTime.now();
        out.println("Текущие дата и время: " + currentDateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss");
        String currentDateTimeFormat = currentDateTime.format(formatter);
        out.println("Текущие дата и время после форматирования: " + currentDateTimeFormat);
    }
}
