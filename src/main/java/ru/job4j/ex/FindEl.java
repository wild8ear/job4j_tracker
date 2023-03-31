package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (key.equals(value[index])) {
                return index;
            }
        }
        throw new ElementNotFoundException("Not found element.");
    }

    public static void main(String[] args) {
        try {
            String[] value = {"1", "2", "3"};
            FindEl.indexOf(value, "key");
        } catch (ElementNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}