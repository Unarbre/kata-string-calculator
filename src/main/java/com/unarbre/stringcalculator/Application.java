package com.unarbre.stringcalculator;


import com.unarbre.stringcalculator.infrastructure.FileReader;

public class Application {
    public static void main(String[] args) {
        try {
            String userInput = new FileReader().read();
            var stringCalculator = new StringCalculator();
            System.out.println(userInput + " = " + stringCalculator.add(userInput));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
