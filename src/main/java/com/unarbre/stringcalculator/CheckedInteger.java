package com.unarbre.stringcalculator;

import com.unarbre.stringcalculator.exceptions.NumberParseException;
import com.unarbre.stringcalculator.utils.NumberUtils;

import java.math.BigInteger;

public record CheckedInteger (BigInteger value) {

    static public CheckedIntegerFromStringBuilder createNewFromString() {
        return new CheckedIntegerFromStringBuilder();
    }

    public BigInteger getValue() {
        return value;
    }

    public static class CheckedIntegerFromStringBuilder {

        private BigInteger value;

        public CheckedIntegerFromStringBuilder rawValue(String numberAsString) {
            var trimmedString = numberAsString.trim();

            if (trimmedString.isEmpty()) {
                value = new BigInteger("0");
                return this;
            }

            if (!NumberUtils.isInteger(trimmedString))
                throw new NumberParseException(numberAsString + " could'nt be parsed as an integer number");

            value =  new BigInteger(trimmedString);
            return this;
        }


        public CheckedInteger build() {
            return new CheckedInteger(value);
        }


    }
}
