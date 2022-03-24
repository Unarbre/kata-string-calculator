package com.unarbre.stringcalculator;

import java.util.Arrays;

final class StringCalculator {

    private static StringCalculator instance;

    private StringCalculator() {}

    public static StringCalculator getInstance() {
        if (instance == null) instance = new StringCalculator();

        return instance;
    }

    public int add(String rawNumbers) {
        var numbers = new int [] { rawNumbers.charAt(0), rawNumbers.charAt(2)};
        return Arrays.stream(numbers).sum();
    }
}
