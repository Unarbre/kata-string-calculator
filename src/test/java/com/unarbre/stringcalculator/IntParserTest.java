package com.unarbre.stringcalculator;

import com.unarbre.stringcalculator.exceptions.NumberParseException;
import com.unarbre.stringcalculator.parser.IntParser;
import com.unarbre.stringcalculator.utils.IntParserUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntParserTest {

    private final IntParser defaultIntParser = IntParserUtils.getDefaultIntParser();

    @Test
    public void should_throw_error_on_separator_without_preceding_number() {
        NumberParseException exception = assertThrows(
                NumberParseException.class, () -> this.defaultIntParser.parse(",3"));

        assertEquals("A delimiter must be preceded from at least one character", exception.getMessage());
    }

    @Test
    public void should_return_zero_on_spaces() {
        assertEquals(
                List.of(CheckedInteger.createNewFromString().rawValue("0").build(),
                        CheckedInteger.createNewFromString().rawValue("0").build()
                ),
                this.defaultIntParser.parse(" , "));

    }

    @Test
    public void should_return_list_of_numbers_on_correctly_separated_numbers() {

        assertEquals(
                List.of(CheckedInteger.createNewFromString().rawValue("3").build(),
                        CheckedInteger.createNewFromString().rawValue("5").build()
                ), this.defaultIntParser.parse("3,5"));
    }

    @Test
    public void should_accept_line_separator_and_semicolons_on_default() {

        assertEquals(
                List.of(CheckedInteger.createNewFromString().rawValue("3").build(),
                        CheckedInteger.createNewFromString().rawValue("5").build(),
                        CheckedInteger.createNewFromString().rawValue("8").build()
                ), this.defaultIntParser.parse("3\n5,8"));
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

        assertEquals("5\n4 could'nt be parsed as an integer number", exception.getMessage());
    }

    @Test
    public void should_take_the_whole_string_on_empty_separator() {
        var emptyCustomParser = IntParserUtils.getCustomIntParser("");

        assertEquals(
                List.of(
                        CheckedInteger.createNewFromString().rawValue("345").build()),
                emptyCustomParser.parse("345"));
    }

}
