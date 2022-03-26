package com.unarbre.stringcalculator.parser;


import com.unarbre.stringcalculator.CheckedInteger;
import com.unarbre.stringcalculator.UserInput;
import com.unarbre.stringcalculator.exceptions.NumberParseException;
import com.unarbre.stringcalculator.parser.separators.SeparatorStrategy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class IntParser {

    private final SeparatorStrategy separatorStrategy;

    public IntParser(SeparatorStrategy separatorStrategy) {
        this.separatorStrategy = separatorStrategy;
    }

    public List<CheckedInteger> parse(UserInput input) {
        return this.parseNumbers("", input.valueToDeque());
    }


    private List<CheckedInteger> parseNumbers(String ongoingString,
                                              Deque<String> remainingInput) {

        return switch (remainingInput) {
            case Deque<String> remain && remain.isEmpty() -> List.of(CheckedInteger
                    .createNewFromString()
                    .rawValue(ongoingString)
                    .build());

            case Deque<String> remain
                    && this.separatorStrategy.hasSeparatorBeenMet(ongoingString + remain.getFirst())
                    && ongoingString.isEmpty() -> throw
                    new NumberParseException("A delimiter must be preceded from at least one character");


            case Deque<String> remain
                    && this.separatorStrategy.hasSeparatorBeenMet(ongoingString + remain.getFirst()) -> new ArrayList<>() {{
                add(CheckedInteger
                        .createNewFromString()
                        .rawValue(separatorStrategy.extractSeparator(ongoingString + remainingInput.pop())).build());
                addAll(parseNumbers("", remainingInput));
            }};

            default -> parseNumbers(ongoingString + remainingInput.pop(), remainingInput);
        };
    }


}
