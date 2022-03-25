package com.unarbre.stringcalculator.parser.separators;

import java.util.Objects;

public class CustomSeparatorStrategy implements SeparatorStrategy {

    private final String separators;

    public CustomSeparatorStrategy(String separators) {
        this.separators = separators;
    }

    @Override
    public boolean isASeparator(String checkedSeparator) {
        return Objects.equals(this.separators, checkedSeparator);
    }
}
