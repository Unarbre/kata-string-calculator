package com.unarbre.stringcalculator.parser.separators;

public class SeparatorUnparsableException extends RuntimeException {

    private final String message;

    public SeparatorUnparsableException(String message) {
        this.message = message;
    }


    @Override
    public String getMessage() {
        return message;
    }
}
