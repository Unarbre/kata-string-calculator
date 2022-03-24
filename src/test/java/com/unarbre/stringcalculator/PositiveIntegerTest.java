package com.unarbre.stringcalculator;

import com.unarbre.stringcalculator.exceptions.NumberParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PositiveIntegerTest {


    @Test
    void should_create_coherent_integer_decorator_on_parsable_string() {
        var number = PositiveInteger
                .createNewFromString()
                .rawValue("43")
                .build();
        assertEquals(43, number.getValue());
    }


    @Test
    void should_not_throw_error_on_negative_value() {
        var number = PositiveInteger
                .createNewFromString()
                        .rawValue("-3")
                                .build();
        assertEquals(-3, number.getValue());
    }

    @Test
    void should_throw_error_on_alphabetical_characters() {
        NumberParseException exception = assertThrows(
                NumberParseException.class, () -> PositiveInteger
                        .createNewFromString()
                        .rawValue("a")
                        .build());
        assertEquals("a could'nt be parsed as an integer positive number", exception.getMessage());
    }

    @Test
    void should_throw_error_on_decimal_value() {
        NumberParseException exception = assertThrows(NumberParseException.class, () -> new PositiveInteger
                .PositiveIntegerFromStringBuilder()
                .rawValue("3.2")
                .build());
        assertEquals("3.2 could'nt be parsed as an integer positive number", exception.getMessage());
    }

    @Test
    public void should_return_zero_when_string_is_empty() {
        var number = PositiveInteger
                .createNewFromString()
                .rawValue("")
                .build();
        assertEquals(0, number.getValue());
    }

}