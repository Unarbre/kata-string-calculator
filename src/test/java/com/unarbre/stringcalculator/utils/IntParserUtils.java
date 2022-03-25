package com.unarbre.stringcalculator.utils;

import com.unarbre.stringcalculator.parser.IntParser;
import com.unarbre.stringcalculator.parser.separators.CustomSeparator;
import com.unarbre.stringcalculator.parser.separators.DefaultSeparator;

public class IntParserUtils {

    public static IntParser getDefaultIntParser() {
        return new IntParser(new DefaultSeparator());
    }

    public static IntParser getCustomIntParser(String separator) {
        return new IntParser(new CustomSeparator(separator));
    }
}
