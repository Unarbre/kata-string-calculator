package com.unarbre.stringcalculator;

import com.unarbre.stringcalculator.parser.IntParser;
import com.unarbre.stringcalculator.parser.separators.SeparatorStrategyFactory;

final class StringCalculator {

    private final SeparatorStrategyFactory separatorStrategyFactory = new SeparatorStrategyFactory();


    public int add(String rawNumbers) {
        var separatorStrategy = this.separatorStrategyFactory.get(rawNumbers);
        var inputParser = new IntParser(separatorStrategy);


        return inputParser.parse(rawNumbers)
                .stream()
                .mapToInt(CheckedInteger::getValue)
                .sum();
    }
}
