package com.unarbre.stringcalculator;


import com.unarbre.stringcalculator.utils.IntParserUtils;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

//STEP 1 GREEN STATE
public class StringCalculatorTest {


    private final StringCalculator stringCalculator = new StringCalculator();

    // region Add


    @Test
    public void should_return_addition_of_numbers_separated_by_coma() {
        assertEquals(this.stringCalculator.add("1,5"), new BigInteger("6"));
    }

    @Test
    public void should_handle_extremly_spaced_numbers() {
        assertEquals(new BigInteger("5"), this.stringCalculator.add("         2,          3"));
    }

    @Test
    public void should_handle_number_being_a_separator() {
        assertEquals(new BigInteger("5"), this.stringCalculator.add("\\5\n253"));
    }

    @Test
    public void should_handle_extremly_large_numbers() {
        assertEquals(new BigInteger("888888888888888"), this.stringCalculator.add("444444444444444,444444444444444"));
    }

    //endregion

}
