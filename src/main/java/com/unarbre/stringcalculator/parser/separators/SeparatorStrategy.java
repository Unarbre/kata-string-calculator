package com.unarbre.stringcalculator.parser.separators;

public interface SeparatorStrategy {
    boolean hasSeparatorBeenMet(String checkedSeparator);
    String extractSeparator(String toExtract);
}
