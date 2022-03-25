package com.unarbre.stringcalculator;

import com.unarbre.stringcalculator.exceptions.NumberParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckedIntegerTest {


    @Test
    void should_create_coherent_integer_decorator_on_parsable_string() {
        var number = CheckedInteger
                .createNewFromString()
                .rawValue("43")
                .build();
        assertEquals(43, number.getValue());
    }


    @Test
    void should_not_throw_error_on_negative_value() {
        var number = CheckedInteger
                .createNewFromString()
                .rawValue("-3")
                .build();
        assertEquals(-3, number.getValue());
    }


    @Test
    void should_handle_untrimmed_numbers() {
        var number = CheckedInteger
                .createNewFromString()
                .rawValue("  33 ")
                .build();
        assertEquals(33, number.getValue());
    }

    @Test
    void should_throw_error_on_alphabetical_characters() {
        NumberParseException exception = assertThrows(
                NumberParseException.class, () -> CheckedInteger
                        .createNewFromString()
                        .rawValue("a")
                        .build());
        assertEquals("a could'nt be parsed as an integer positive number", exception.getMessage());
    }

    @Test
    void should_throw_error_on_decimal_value() {
        NumberParseException exception = assertThrows(NumberParseException.class, () -> new CheckedInteger
                .PositiveIntegerFromStringBuilder()
                .rawValue("3.2")
                .build());
        assertEquals("3.2 could'nt be parsed as an integer positive number", exception.getMessage());
    }

    @Test
    public void should_return_zero_when_string_is_empty() {
        var number = CheckedInteger
                .createNewFromString()
                .rawValue("")
                .build();
        assertEquals(0, number.getValue());
    }

}
