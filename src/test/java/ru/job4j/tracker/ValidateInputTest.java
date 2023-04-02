package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenValidInnput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenMultyValidInnput() {
        Output out = new StubOutput();
        String[] commands = new String[] {"0", "1", "2"};
        Input in = new StubInput(commands);
        for (String select : commands) {
            ValidateInput input = new ValidateInput(out, in);
            int selected = input.askInt("Enter menu:");
            assertThat(selected).isEqualTo(Integer.parseInt(select));
        }

    }

    @Test
    public void whenNegativeNumberInnput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}