package com.unarbre.stringcalculator.parser.separators;

import java.util.List;

public class DefaultSeparator implements SeparatorStrategy {

    private final String[] SEPARATORS = {",", "\n"};

    @Override
    public boolean isASeparator(String checkedSeparator) {
        return List.of(SEPARATORS).contains(checkedSeparator);
    }
}
