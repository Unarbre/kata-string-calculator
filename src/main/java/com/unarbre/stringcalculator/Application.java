package com.unarbre.stringcalculator;


public class Application {
    public static void main(String[] args) {
        try {
            var stringCalculator = new StringCalculator();
            System.out.println(
                    args[0] + " = " + stringCalculator.add(args[0])
            );
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.err.println("Please provide at least one argument");
        }
    }
}
