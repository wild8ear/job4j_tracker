package ru.job4j.queue;

import java.util.LinkedList;
import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String rsl = "";
        LinkedList<Customer> c = new LinkedList<>(queue);
        for (int i = 0; i < queue.size(); i++) {
            if (i == count - 1) {
                rsl = c.get(i).name();
                break;
            }
        }
        return rsl;
    }

    public String getFirstUpsetCustomer() {
        String rsl = "";
        LinkedList<Customer> c = new LinkedList<>(queue);
        for (int i = 0; i < queue.size(); i++) {
            if (i > count - 1) {
                rsl = c.get(i).name();
                break;
            }
        }
        return rsl;
    }
}