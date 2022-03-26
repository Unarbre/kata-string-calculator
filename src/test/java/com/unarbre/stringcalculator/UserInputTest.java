package com.unarbre.stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void should_return_empty_string_if_no_separator() {
        assertEquals("", new UserInput("33").getSeparator());
    }

    @Test
    public void should_return_value_without_separator() {
        assertEquals("33", new UserInput("\\dog\n33").getCleanedValue());
    }

    @Test
    public void should_return_value_without_separator_on_absent_separaot() {
        assertEquals("333", new UserInput("333").getCleanedValue());
    }
}
