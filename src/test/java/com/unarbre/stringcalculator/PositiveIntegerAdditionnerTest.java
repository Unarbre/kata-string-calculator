package com.unarbre.stringcalculator;

import com.unarbre.stringcalculator.exceptions.UnacceptableValueException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PositiveIntegerAdditionnerTest {

    private final PositiveIntegerAdditionner positiveIntegerAdditionner = new PositiveIntegerAdditionner();

    @Test
    public void should_return_addition_of_list() {
        Assertions.assertEquals(
                this.positiveIntegerAdditionner.add(List.of(
                                new CheckedInteger(new BigInteger("10")),
                                new CheckedInteger(new BigInteger("10")),
                                new CheckedInteger(new BigInteger("5")),
                                new CheckedInteger(new BigInteger("5"))
                        )
                ),
                new BigInteger("30")
        );
    }


    @Test
    public void should_return_zero_on_empty_list() {
        Assertions.assertEquals(this.positiveIntegerAdditionner.add(List.of()), new BigInteger("0"));
    }

    @Test
    public void should_throw_error_on_negative_value_in_list() {
        UnacceptableValueException exception = assertThrows(
                UnacceptableValueException.class, () -> this.positiveIntegerAdditionner.add(List.of(
                                new CheckedInteger(new BigInteger("30")),
                                new CheckedInteger(new BigInteger("-4"))
                        )
                )
        );

        assertEquals("negative not allowed : -4", exception.getMessage());
    }

    @Test
    public void should_throw_error_with_all_negative_values_in_list() {
        UnacceptableValueException exception = assertThrows(
                UnacceptableValueException.class, () -> this.positiveIntegerAdditionner.add(List.of(
                                new CheckedInteger(new BigInteger("10")),
                                new CheckedInteger(new BigInteger("-4")),
                                new CheckedInteger(new BigInteger("-8")),
                                new CheckedInteger(new BigInteger("-32"))
                        )
                )
        );

        assertEquals("negative not allowed : -4, -8, -32", exception.getMessage());
    }


}
