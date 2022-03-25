package com.unarbre.stringcalculator;

import com.unarbre.stringcalculator.parser.IntParser;

final class StringCalculator {

    private final IntParser inputParser;

    public StringCalculator(IntParser inputParser) {
        this.inputParser = inputParser;
    }

    public int add(String rawNumbers) {
        return inputParser.parse(rawNumbers)
                .stream()
                .mapToInt(PositiveInteger::getValue)
                .sum();
    }
}
