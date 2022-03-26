package com.unarbre.stringcalculator.structures.operator;

import java.util.List;

public interface Additionner<Added, Resulting> {

    Resulting add(List<Added> addedList);
}
