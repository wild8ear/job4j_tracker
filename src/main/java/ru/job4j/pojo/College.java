package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Ivanov Ivan Ivanovich");
        student.setGroup("A-4343");
        student.setDateOfAdmission(new Date());

        System.out.println(student.getFio() + " is a student of the gruop " + student.getGroup()
            + " who entered: " + student.getDateOfAdmission());
    }
}
