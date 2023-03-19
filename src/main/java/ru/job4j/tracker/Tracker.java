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
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
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
        return  Arrays.copyOf(rsl, i);
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
        return Arrays.copyOf(rsl, i);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        items[index] = null;
        int start = index + 1;
        int dispPos = index;
        System.arraycopy(items, start, items, dispPos, items.length - 1 - index);
        items[items.length - 1] = null;
        size--;
        return true;
    }
}