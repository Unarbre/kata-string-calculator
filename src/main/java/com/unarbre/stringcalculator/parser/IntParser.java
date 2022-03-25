package com.unarbre.stringcalculator.parser;


import com.unarbre.stringcalculator.CheckedInteger;
import com.unarbre.stringcalculator.exceptions.NumberParseException;

import java.util.*;
import java.util.stream.Collectors;

public class IntParser {

    private final String[] SEPARATORS = {",", "\n"};

    public List<CheckedInteger> parse(String input) {
        var charQueue = new ArrayDeque<>(Arrays.asList(input.split("")));
        return this.parseNumbers("", charQueue);
    }


    private List<CheckedInteger> parseNumbers(String ongoingString,
                                              Deque<String> remainingInput) {

        return switch (remainingInput) {
            case Deque<String> remain && remain.isEmpty() -> List.of(CheckedInteger
                    .createNewFromString()
                    .rawValue(ongoingString)
                    .build());

            case Deque<String> remain
                    && Arrays.asList(SEPARATORS).contains(remain.getFirst())
                    && ongoingString.isEmpty() -> throw
                    new NumberParseException("A delimiter must be preceded from at least one character");


            case Deque<String> remain
                    &&  Arrays.asList(SEPARATORS).contains(remain.getFirst()) -> new ArrayList<>() {{
                add(CheckedInteger.createNewFromString().rawValue(ongoingString).build());
                addAll(parseNumbers("", remainingInput.stream().skip(1).collect(Collectors.toCollection(ArrayDeque::new))));
            }};

            default -> parseNumbers(ongoingString + remainingInput.pop(), remainingInput);
        };
    }


}
