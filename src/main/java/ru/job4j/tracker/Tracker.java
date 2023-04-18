package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int rsl = indexOf(id);
        return rsl != -1 ? items.get(rsl) : null;
    }

    private int indexOf(int id) {
        int rsl  = -1;
        for (Item item: items) {
            if (item.getId() == id) {
                rsl = item.getId() - 1;
                break;
            }
        }
        return rsl;
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        int i = 0;
        for (Item item : items) {
            if (key.equals(item.getName())) {
                rsl.add(item);
                i++;
            }
        }
        return rsl;
    }

    public List<Item> findAll() {
        List<Item> newItems = new ArrayList<>();
        for (Item item : items) {
            newItems.add(item);
        }
        return newItems;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1 && item != null;
        if (rsl) {
            item.setId(id);
            items.add(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
            size--;
        }
        return rsl;
    }
}