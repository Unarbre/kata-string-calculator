package com.unarbre.stringcalculator;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//STEP 1 RED STATE
public class StringCalculatorTest {


    private final StringCalculator stringCalculator = StringCalculator.getInstance();

    // region Add


    @Test
    public void should_return_addition_of_numbers_separated_by_coma() {
        assertEquals(this.stringCalculator.add("1,5"), 6);
    }


    @Test
    public void should_return_zero_when_string_is_null() {
        assertEquals(this.stringCalculator.add(""), 0);
    }


    @Test
    public void should_return_first_value_if_there_is_only_one() {
        assertEquals(this.stringCalculator.add("3, "), 3);
    }

    @Test
    public void should_throw_parse_error_if_any_value_is_not_a_number() {
        NumberParseException exception = assertThrows(NumberParseException.class, () -> this.stringCalculator.add("a, 3"));
        assertEquals(exception.getMessage(), "a is not a valid number");
    }

    //endregion

}
