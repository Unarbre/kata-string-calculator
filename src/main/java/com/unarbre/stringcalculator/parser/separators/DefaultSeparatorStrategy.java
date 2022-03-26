package com.unarbre.stringcalculator.parser.separators;

import java.util.Arrays;
import java.util.List;


public class DefaultSeparatorStrategy implements SeparatorStrategy {

    private final String[] SEPARATORS = {",", "\n"};

    @Override
    public boolean hasSeparatorBeenMet(String checkedString) {
        return Arrays.stream(SEPARATORS).anyMatch(checkedString::endsWith);
    }

    @Override
    public String extractSeparator(String toExtract) {
        return toExtract.substring(0, toExtract.length() - 1);
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
