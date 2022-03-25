package com.unarbre.stringcalculator.parser;


import com.unarbre.stringcalculator.PositiveInteger;
import com.unarbre.stringcalculator.exceptions.NumberParseException;

import java.util.*;
import java.util.stream.Collectors;

public class IntParser {

    private final String[] SEPARATORS = {",", "\n"};

    public List<PositiveInteger> parse(String input) {
        var charQueue = new ArrayDeque<>(Arrays.asList(input.split("")));
        return this.parseNumbers("", charQueue);
    }


    private List<PositiveInteger> parseNumbers(String ongoingString,
                                               Deque<String> remainingInput) {

        return switch (remainingInput) {
            case Deque<String> remain && remain.isEmpty() -> List.of(PositiveInteger
                    .createNewFromString()
                    .rawValue(ongoingString)
                    .build());

            case Deque<String> remain
                    && Arrays.asList(SEPARATORS).contains(remain.getFirst())
                    && ongoingString.isEmpty() -> throw
                    new NumberParseException("A delimiter must be preceded from at least one character");


            case Deque<String> remain
                    &&  Arrays.asList(SEPARATORS).contains(remain.getFirst()) -> new ArrayList<>() {{
                add(PositiveInteger.createNewFromString().rawValue(ongoingString).build());
                addAll(parseNumbers("", remainingInput.stream().skip(1).collect(Collectors.toCollection(ArrayDeque::new))));
            }};

            default -> parseNumbers(ongoingString + remainingInput.pop(), remainingInput);
        };
    }


}
