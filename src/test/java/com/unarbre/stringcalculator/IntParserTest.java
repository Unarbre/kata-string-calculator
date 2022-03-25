package com.unarbre.stringcalculator;

import com.unarbre.stringcalculator.exceptions.NumberParseException;
import com.unarbre.stringcalculator.parser.IntParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntParserTest {

    private final IntParser intParser = new IntParser();

    @Test
    public void should_throw_error_on_separator_without_preceding_number() {
        NumberParseException exception = assertThrows(NumberParseException.class,
                () -> this.intParser.parse(",3"));

        assertEquals("A delimiter must be preceded from at least one character", exception.getMessage());
    }

    @Test
    public void should_return_zero_on_spaces() {
        assertEquals(
                List.of(PositiveInteger.createNewFromString().rawValue("0").build(),
                        PositiveInteger.createNewFromString().rawValue("0").build()
                ),
                this.intParser.parse(" , "));

    }

    @Test
    public void should_return_list_of_numbers_on_correctly_separated_numbers() {

        assertEquals(List.of(PositiveInteger.createNewFromString().rawValue("3").build(),
                PositiveInteger.createNewFromString().rawValue("5").build()
        ), this.intParser.parse("3,5"));
    }

}
