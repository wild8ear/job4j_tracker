package ru.job4j.record;

public record PersonRecord(String name, int age, String surname) implements Comparable<PersonRecord> {
    public static int maxAge = 100;

    public PersonRecord {
        if (age > 101) {
            throw new IllegalArgumentException("Возраст должен быть менее 101");
        }
    }

    public static int getMaxAge() {
        return maxAge;
    }

    public void info() {
        System.out.println("Напечатать информацию");
    }

    @Override
    public String toString() {
        return "Person{"
                + "name='" + name + '\''
                + ", age=" + age + '\''
                + ", surname='" + surname + '\''
                + '}';
    }

    @Override
    public int compareTo(PersonRecord o) {
        return name.compareTo(o.name);
    }
}