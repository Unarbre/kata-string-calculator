package com.unarbre.stringcalculator;

import com.unarbre.stringcalculator.parser.separators.SeparatorUnparsableException;

import java.util.ArrayDeque;
import java.util.Arrays;

public class UserInput {

    private final String START_SEPARATOR_STRING = "\\";
    private final String END_SEPARATOR_STRING = "\n";

    private final String value;

    public UserInput(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


    public String getSeparator() {
        if (!this.hasSeparator()) return "";

        var indexOfSeparator = this.value.indexOf("\n");
        if (indexOfSeparator == -1) {
            throw new SeparatorUnparsableException(this.value + " separator couldn't be parse. " +
                    "Please provide an \\n at the end of the separator");
        }

        return this.value.substring(1, this.value.indexOf("\n"));
    }

    public String getCleanedValue() {
        return this.hasSeparator()
                ? this.withoutSeparator()
                : this.value;
    }

    private String withoutSeparator() {
        return this.value.substring(
                this.value.indexOf(this.END_SEPARATOR_STRING) + 1);
    }

    public boolean hasSeparator() {
        return this.value.startsWith(this.START_SEPARATOR_STRING);
    }

    public ArrayDeque<String> valueToDeque() {
        return new ArrayDeque<>(Arrays.asList(this.getCleanedValue().split("")));
    }
}
