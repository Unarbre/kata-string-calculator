package com.unarbre.stringcalculator;

import com.unarbre.stringcalculator.exceptions.NumberParseException;
import com.unarbre.stringcalculator.utils.NumberUtils;

public record CheckedInteger (int value) {

    static public CheckedIntegerFromStringBuilder createNewFromString() {
        return new CheckedIntegerFromStringBuilder();
    }

    public int getValue() {
        return value;
    }

    public static class CheckedIntegerFromStringBuilder {

        private int value;

        public CheckedIntegerFromStringBuilder() {

        }

        public CheckedIntegerFromStringBuilder rawValue(String numberAsString) {
            var trimmedString = numberAsString.trim();

            if (trimmedString.isEmpty()) {
                value = 0;
                return this;
            }

            if (!NumberUtils.isInteger(trimmedString))
                throw new NumberParseException(numberAsString + " could'nt be parsed as an integer number");

            value = Integer.parseInt(trimmedString);
            return this;
        }


        public CheckedInteger build() {
            return new CheckedInteger(value);
        }


    }
}
