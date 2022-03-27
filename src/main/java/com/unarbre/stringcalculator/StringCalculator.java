package com.unarbre.stringcalculator;

import com.unarbre.stringcalculator.parser.IntParser;
import com.unarbre.stringcalculator.parser.separators.SeparatorStrategyFactory;

final class StringCalculator {

    private final SeparatorStrategyFactory separatorStrategyFactory = new SeparatorStrategyFactory();


    public int add(String rawInput) {
        var userInput = new UserInput(rawInput);
        var separatorStrategy = this.separatorStrategyFactory.get(userInput);
        var inputParser = new IntParser(separatorStrategy);
        var additionner = new PositiveIntegerAdditionner();

        return additionner.add(inputParser.parse(userInput));
    }
}
