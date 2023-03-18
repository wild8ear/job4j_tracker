package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[items.length];
        int i = 0;
        for (int index = 0; index < size; index++) {
            if (key.equals(items[index].getName())) {
                rsl[i] = items[index];
                i++;
            }
        }
        rsl = Arrays.copyOf(rsl, i);
        return  rsl;
    }

    public Item[] findAll() {
        Item[] rsl = new Item[size];
        int i = 0;
        for (int index = 0; index < size; index++) {
            if (items[index].getName() != null) {
                rsl[i] = items[index];
                i++;
            }
        }
        rsl = Arrays.copyOf(rsl, i);
        return rsl;
    }
}