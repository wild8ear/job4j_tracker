package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemDescByNameTest {
    @Test
    public void whenItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item("Second"),
                new Item("Third"),
                new Item("First"));
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("Third"),
                new Item("Second"),
                new Item("First"));
        assertThat(expected).isEqualTo(items);
    }
}
