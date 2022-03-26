package com.unarbre.stringcalculator.infrastructure;

public class UnreadableException extends RuntimeException{

    private final String message;

    public UnreadableException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
