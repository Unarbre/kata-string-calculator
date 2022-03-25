package com.unarbre.stringcalculator;

import com.unarbre.stringcalculator.exceptions.NumberParseException;
import com.unarbre.stringcalculator.utils.NumberUtils;

import java.util.Objects;

public class PositiveInteger {

    private final int value;

    private PositiveInteger(int value) {

        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveInteger that = (PositiveInteger) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "PositiveInteger{" +
                "value=" + value +
                '}';
    }

    static public PositiveIntegerFromStringBuilder createNewFromString() {
        return new PositiveIntegerFromStringBuilder();
    }

    public int getValue() {
        return value;
    }

    public static class PositiveIntegerFromStringBuilder {

        private int value;

        public PositiveIntegerFromStringBuilder() {

        }

        public PositiveIntegerFromStringBuilder rawValue(String numberAsString) {
            var trimmedString = numberAsString.trim();

            if (trimmedString.isEmpty()) {
                value = 0;
                return this;
            }

            if (!NumberUtils.isInteger(trimmedString))
                throw new NumberParseException(numberAsString + " could'nt be parsed as an integer positive number");

            value = Integer.parseInt(trimmedString);
            return this;
        }



        public PositiveInteger build() {
            return new PositiveInteger(value);
        }


    }
}
