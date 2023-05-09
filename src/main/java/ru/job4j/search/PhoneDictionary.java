package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> compareAddress = (person) -> key.equals(person.getAddress());
        Predicate<Person> compareName = (person) -> key.equals(person.getName());
        Predicate<Person> compareSurname = (person) -> key.equals(person.getSurname());
        Predicate<Person> comparePhone = (person) -> key.equals(person.getPhone());
        Predicate<Person> combine = compareAddress.or(compareName).or(compareSurname).or(comparePhone);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}