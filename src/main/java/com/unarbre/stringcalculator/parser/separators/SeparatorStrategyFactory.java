package com.unarbre.stringcalculator.parser.separators;

import com.unarbre.stringcalculator.UserInput;
import com.unarbre.stringcalculator.structures.Factory;

public class SeparatorStrategyFactory implements Factory<UserInput, SeparatorStrategy> {

    @Override
    public SeparatorStrategy get(UserInput source) {
        if (source.hasSeparator())
            return new CustomSeparatorStrategy(source.getSeparator());

        return new DefaultSeparatorStrategy();
    }
}
