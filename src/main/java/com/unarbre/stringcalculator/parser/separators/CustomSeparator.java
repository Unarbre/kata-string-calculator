package com.unarbre.stringcalculator.parser.separators;

import java.util.Objects;

public class CustomSeparator implements SeparatorStrategy {

    private final String separators;

    public CustomSeparator(String separators) {
        this.separators = separators;
    }

    @Override
    public boolean isASeparator(String checkedSeparator) {
        return Objects.equals(this.separators, checkedSeparator);
    }
}
