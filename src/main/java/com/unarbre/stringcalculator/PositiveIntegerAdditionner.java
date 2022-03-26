package com.unarbre.stringcalculator;

import com.unarbre.stringcalculator.exceptions.UnacceptableValueException;
import com.unarbre.stringcalculator.structures.operator.Additionner;

import java.util.List;
import java.util.stream.Collectors;

public class PositiveIntegerAdditionner implements Additionner<CheckedInteger, Integer> {
    @Override
    public Integer add(List<CheckedInteger> checkedIntegers) {
        if (this.containsNegativeValue(checkedIntegers)) {
            throw new UnacceptableValueException("negative not allowed : " +
                    checkedIntegers.stream()
                            .map(CheckedInteger::getValue)
                            .filter(n -> n < 0)
                            .map(String::valueOf)
                            .collect(Collectors.joining(", ")));
        }

        return checkedIntegers.stream().mapToInt(CheckedInteger::getValue).sum();
    }


    private boolean containsNegativeValue(List<CheckedInteger> numbers) {
        return numbers.stream().anyMatch(n -> n.getValue() < 0);
    }
}
