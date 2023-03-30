package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

public class FactTest {
    @Test
    public void whenNumberLessZero() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> {
                Fact.calc(-1);

            });
        assertThat(exception.getMessage()).isEqualTo("N could not be less than 0");
    }

    @Test
    public void whenTenThan() {
        int n = 10;
        int expected = 3628800;
        int result = Fact.calc(n);
        assertThat(expected).isEqualTo(result);
    }
}
