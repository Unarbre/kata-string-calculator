package com.unarbre.stringcalculator;

import com.unarbre.stringcalculator.exceptions.NumberParseException;
import com.unarbre.stringcalculator.utils.NumberUtils;

import java.util.Arrays;
import java.util.stream.Stream;

public class PositiveInteger {

    private final int value;

    private PositiveInteger(int value) {

        this.value = value;
    }

   static public PositiveIntegerFromStringBuilder createNewFromString() {
        return new PositiveIntegerFromStringBuilder();
    }

    public int getValue() {
        return value;
    }

    static class PositiveIntegerFromStringBuilder {

        private int value;

        public PositiveIntegerFromStringBuilder() {

        }

        public PositiveIntegerFromStringBuilder rawValue(String numberAsString) {
            if (!NumberUtils.isInteger(numberAsString))
                throw new NumberParseException(numberAsString + " could'nt be parsed as an integer positive number");

            value = Integer.parseInt(numberAsString);
            return this;
        }



        public PositiveInteger build() {
            return new PositiveInteger(value);
        }


    }
}
