package com.unarbre.stringcalculator;

import com.unarbre.stringcalculator.exceptions.NumberParseException;
import com.unarbre.stringcalculator.parser.IntParser;
import com.unarbre.stringcalculator.utils.IntParserUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntParserTest {

    private final IntParser intParser = new IntParser();

    @Test
    public void should_throw_error_on_separator_without_preceding_number() {
        NumberParseException exception = assertThrows(
                NumberParseException.class, () -> this.intParser.parse(",3"));

        assertEquals("A delimiter must be preceded from at least one character", exception.getMessage());
    }

    @Test
    public void should_return_zero_on_spaces() {
        assertEquals(
                List.of(CheckedInteger.createNewFromString().rawValue("0").build(),
                        CheckedInteger.createNewFromString().rawValue("0").build()
                ),
                this.intParser.parse(" , "));

    }

    @Test
    public void should_return_list_of_numbers_on_correctly_separated_numbers() {

        assertEquals(
                List.of(CheckedInteger.createNewFromString().rawValue("3").build(),
                        CheckedInteger.createNewFromString().rawValue("5").build()
                ), this.intParser.parse("3,5"));
    }

    @Test
    public void should_accept_line_separator_and_semicolon_as_separators() {

        assertEquals(
                List.of(CheckedInteger.createNewFromString().rawValue("3").build(),
                        CheckedInteger.createNewFromString().rawValue("5").build(),
                        CheckedInteger.createNewFromString().rawValue("8").build()
                ), this.intParser.parse("3\n5,8"));
    }

    @Test
    public void should_accept_any_separators_on_custom() {
        var bParser = IntParserUtils.getCustomIntParser("b");



        assertEquals(
                List.of(CheckedInteger.createNewFromString().rawValue("3").build(),
                        CheckedInteger.createNewFromString().rawValue("5").build(),
                        CheckedInteger.createNewFromString().rawValue("8").build()
                ), bParser.parse("3b5b8"));
    }

    @Test
    public void should_accept_only_custom_character_on_custom_separator() {
        var onlySemicolonParser = IntParserUtils.getCustomIntParser(";");
        NumberParseException exception = assertThrows(
                NumberParseException.class, () -> onlySemicolonParser.parse("3;5\n4"));

        assertEquals("5\n4 could'nt be parsed as an integer positive number", exception.getMessage());
    }

}
