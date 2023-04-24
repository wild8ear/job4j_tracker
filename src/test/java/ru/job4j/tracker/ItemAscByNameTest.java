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
        Collections.sort(items);
        List<Item> expected = Arrays.asList(
                new Item("Second"),
                new Item("Third"),
                new Item("First"));
        expected.sort(new ItemAscByName());
        assertThat(expected.toString()).isEqualTo(items.toString());
    }
}
