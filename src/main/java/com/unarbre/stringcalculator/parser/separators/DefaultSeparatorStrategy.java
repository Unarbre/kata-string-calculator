package com.unarbre.stringcalculator.parser.separators;

import java.util.Arrays;
import java.util.List;


public class DefaultSeparatorStrategy implements SeparatorStrategy {

    private final String[] SEPARATORS = {",", "\n"};

    @Override
    public boolean isASeparator(String checkedSeparator) {
        return List.of(SEPARATORS).contains(checkedSeparator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultSeparatorStrategy that = (DefaultSeparatorStrategy) o;
        return Arrays.equals(SEPARATORS, that.SEPARATORS);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(SEPARATORS);
    }

    @Override
    public String toString() {
        return "DefaultSeparatorStrategy{" +
                "SEPARATORS=" + Arrays.toString(SEPARATORS) +
                '}';
    }
}
