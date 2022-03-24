package com.unarbre.stringcalculator.utils;

import java.util.List;
import java.util.stream.Stream;

public class NumberUtils {

    static List<String> NUMBERS_AS_STRING = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
    static String NEGATIVE_MARKER = "-";

    public static boolean isInteger(String numberAsString) {
        return Stream.of(
                        cleanNegative(numberAsString)
                                .split(""))
                .allMatch(s -> NUMBERS_AS_STRING.contains(s));
    }

    private static String cleanNegative(String numberAsString) {
        return numberAsString.startsWith(NEGATIVE_MARKER)
                ? numberAsString.substring(1)
                : numberAsString;
    }
}
