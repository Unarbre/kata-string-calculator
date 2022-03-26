package com.unarbre.stringcalculator.exceptions;

public class UnacceptableValueException extends RuntimeException {
    private final String message;

    public UnacceptableValueException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
