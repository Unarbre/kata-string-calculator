package com.unarbre.stringcalculator;


import com.unarbre.stringcalculator.exceptions.NumberParseException;
import com.unarbre.stringcalculator.parser.IntParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//STEP 1 GREEN STATE
public class StringCalculatorTest {


    private final StringCalculator stringCalculator = new StringCalculator(new IntParser());

    // region Add


    @Test
    public void should_return_addition_of_numbers_separated_by_coma() {
        assertEquals(this.stringCalculator.add("1,5"), 6);
    }

    @Test
    public void should_handle_extremly_spaced_numbers() {
        assertEquals(5, this.stringCalculator.add("         2,          3"));
    }

    //endregion

}
