package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemDescByNameTest {
    @Test
    public void whenItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item("Second"),
                new Item("Third"),
                new Item("First"));
        Collections.sort(items);
        List<Item> expected = Arrays.asList(
                new Item("Second"),
                new Item("Third"),
                new Item("First"));
        expected.sort(new ItemDescByName());
        assertThat(expected.toString()).isNotEqualTo(items.toString());
    }
}
