package com.unarbre.stringcalculator;

import com.unarbre.stringcalculator.parser.separators.SeparatorUnparsableException;

public class UserInput {

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
        return this.value.substring(this.value.indexOf("\n") + 1);
    }

    public boolean hasSeparator() {
        return this.value.startsWith("\\");
    }
}
