package com.unarbre.stringcalculator.parser.separators;

import java.util.Objects;

public class CustomSeparatorStrategy implements SeparatorStrategy {

    private final String separator;

    public CustomSeparatorStrategy(String separator) {
        this.separator = separator;
    }

    @Override
    public boolean hasSeparatorBeenMet(String checkedString) {
        if (separator.isEmpty()) return false;
        return checkedString.endsWith(separator);
    }

    @Override
    public String extractSeparator(String toExtract) {
        return toExtract.substring(0, toExtract.length() - this.separator.length());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomSeparatorStrategy that = (CustomSeparatorStrategy) o;
        return Objects.equals(separator, that.separator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(separator);
    }

    @Override
    public String toString() {
        return "CustomSeparatorStrategy{" +
                "separators='" + separator + '\'' +
                '}';
    }
}
