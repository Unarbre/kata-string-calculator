package com.unarbre.stringcalculator;


import com.unarbre.stringcalculator.utils.IntParserUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//STEP 1 GREEN STATE
public class StringCalculatorTest {


    private final StringCalculator stringCalculator = new StringCalculator();

    // region Add


    @Test
    public void should_return_addition_of_numbers_separated_by_coma() {
        assertEquals(this.stringCalculator.add("1,5"), 6);
    }

    @Test
    public void should_handle_extremly_spaced_numbers() {
        assertEquals(5, this.stringCalculator.add("         2,          3"));
    }

    @Test
    public void should_handle_number_being_a_separator() {
        assertEquals(5, this.stringCalculator.add("\\5\n253"));
    }

    //endregion

}
