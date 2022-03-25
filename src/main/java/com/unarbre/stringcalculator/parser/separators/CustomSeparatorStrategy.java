package com.unarbre.stringcalculator.parser.separators;

import java.util.Objects;

public class CustomSeparatorStrategy implements SeparatorStrategy {

    private final String separator;

    public CustomSeparatorStrategy(String separator) {
        this.separator = separator;
    }

    @Override
    public boolean isASeparator(String checkedSeparator) {
        return Objects.equals(this.separator, checkedSeparator);
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
