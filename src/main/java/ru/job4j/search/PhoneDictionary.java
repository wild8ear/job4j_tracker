package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> compareAddress = (person) -> key.contains(person.getAddress());
        Predicate<Person> compareName = (person) -> key.contains(person.getName());
        Predicate<Person> compareSurname = (person) -> key.contains(person.getSurname());
        Predicate<Person> comparePhone = (person) -> key.contains(person.getPhone());
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