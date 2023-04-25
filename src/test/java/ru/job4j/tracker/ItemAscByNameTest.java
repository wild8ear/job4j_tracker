package ru.job4j.tracker;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ItemAscByNameTest {
    @Test
    public void whenItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item("Second"),
                new Item("Third"),
                new Item("First"));
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("First"),
                new Item("Second"),
                new Item("Third"));
        assertThat(expected).isEqualTo(items);
    }
}
