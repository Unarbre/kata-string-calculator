package com.unarbre.stringcalculator;

final class StringCalculator {

    private static StringCalculator instance;

    private StringCalculator() {}

    public static StringCalculator getInstance() {
        if (instance == null) instance = new StringCalculator();

        return instance;
    }


}
