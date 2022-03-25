package com.unarbre.stringcalculator.utils;

import com.unarbre.stringcalculator.parser.IntParser;
import com.unarbre.stringcalculator.parser.separators.CustomSeparatorStrategy;
import com.unarbre.stringcalculator.parser.separators.DefaultSeparatorStrategy;

public class IntParserUtils {

    public static IntParser getDefaultIntParser() {
        return new IntParser(new DefaultSeparatorStrategy());
    }

    public static IntParser getCustomIntParser(String separator) {
        return new IntParser(new CustomSeparatorStrategy(separator));
    }
}
