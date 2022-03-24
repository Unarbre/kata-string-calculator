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
    public void should_return_first_value_if_second_is_empty() {
        assertEquals(3, this.stringCalculator.add("3, "));
    }

    @Test
    public void should_return_second_value_if_first_is_empty() {
        assertEquals(3, this.stringCalculator.add(",3"));
    }

    //endregion

}
