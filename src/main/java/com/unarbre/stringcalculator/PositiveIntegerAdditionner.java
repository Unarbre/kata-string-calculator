package com.unarbre.stringcalculator;

import com.unarbre.stringcalculator.exceptions.UnacceptableValueException;
import com.unarbre.stringcalculator.structures.operator.Additionner;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveIntegerAdditionner implements Additionner<CheckedInteger, BigInteger> {
    @Override
    public BigInteger add(List<CheckedInteger> checkedIntegers) {
        if (this.containsNegativeValue(checkedIntegers)) {
            throw new UnacceptableValueException("negative not allowed : " +
                    checkedIntegers.stream()
                            .map(integer -> integer.getValue().intValue())
                            .filter(n -> n < 0)
                            .map(String::valueOf)
                            .collect(Collectors.joining(", ")));
        }

        return checkedIntegers.stream()
                .map(CheckedInteger::getValue)
                .reduce(new BigInteger("0"), BigInteger::add);
    }


    private boolean containsNegativeValue(List<CheckedInteger> numbers) {
        return numbers.stream()
                .map(CheckedInteger::getValue)
                .anyMatch(n -> n.signum() == -1);
    }
}
