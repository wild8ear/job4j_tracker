package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String>  accounts = new HashMap<>();
        accounts.put("email@gmail.com", "Ivanov");
        accounts.put("email@mail.com", "Petrov");
        for (String key: accounts.keySet()) {
            System.out.println(key + " = " + accounts.get(key));
        }
    }
}
