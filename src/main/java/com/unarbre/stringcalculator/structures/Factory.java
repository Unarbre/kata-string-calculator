package com.unarbre.stringcalculator.structures;

public interface Factory<Builded, From> {
    Builded get(From source);
}
