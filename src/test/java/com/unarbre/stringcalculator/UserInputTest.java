package com.unarbre.stringcalculator;

import com.unarbre.stringcalculator.parser.separators.SeparatorUnparsableException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserInputTest {

    @Test
    public void should_instantiate_user_input() {
        assertEquals("444", new UserInput("444").getValue());
    }

    @Test
    public void should_return_separator_string_property() {
        assertEquals("dog", new UserInput("\\dog\n33").getSeparator());
    }

    @Test
    public void should_throw_error_on_unspecified_end_of_separator() {
        SeparatorUnparsableException exception = assertThrows(
                SeparatorUnparsableException.class, () -> new UserInput("\\dog").getSeparator());

        assertEquals("\\dog separator couldn't be parse. Please provide an \\n at the end of the separator", exception.getMessage());
    }

    @Test
    public void should_handle_empty_separator_and_empty_value() {
        assertEquals("", new UserInput("\\\n").getSeparator());
    }

    @Test
    public void should_return_empty_string_if_no_separator() {
        assertEquals("", new UserInput("33").getSeparator());
    }

    @Test
    public void should_return_value_without_separator() {
        assertEquals("33", new UserInput("\\dog\n33").getCleanedValue());
    }

    @Test
    public void should_return_value_without_separator_on_absent_separator() {
        assertEquals("333", new UserInput("333").getCleanedValue());
    }
}
