package com.unarbre.stringcalculator.exceptions;

public class NumberParseException extends RuntimeException {

    private final String message;


    public NumberParseException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
