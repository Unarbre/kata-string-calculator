package com.unarbre.stringcalculator.structures;

public interface Factory<From, Builded> {
    Builded get(From source);
}
