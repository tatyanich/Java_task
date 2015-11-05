package com.epam.tetiana_matiunina.java.task4.lesson4;

import com.epam.tetiana_matiunina.java.task4.lesson4.operation.*;
import com.epam.tetiana_matiunina.java.task4.lesson4.validator.Validator;

import java.util.Objects;
import java.util.Scanner;

/**
 * Created by Tetiana_Matiunina on 26.10.2015.
 */
public class Demo {
    private static Calculator calculator;

    /**
     * initialization of operators and object variable
     */
    public static void init() {
        calculator = new Calculator();
        calculator.addOperation(new Addition());
        calculator.addOperation(new Division());
        calculator.addOperation(new Multiplication());
        calculator.addOperation(new Subtraction());
    }

    public static void main(String[] args) {

        System.out.println("Please enter math expression:");
        String expressionString = new Scanner(System.in).nextLine();

        String errorOfInput = Validator.validate(Parser.parseExpression(expressionString));
        if (!errorOfInput.isEmpty()) {
            System.out.println(errorOfInput);
        } else {
            init();
            String[] array = Parser.parseExpression(expressionString);

            double first = Double.valueOf(array[0]);
            double second = Double.valueOf(array[2]);
//            Double a =calculator.calculate(array[1], first, second);
//            if (Objects.equals(a, Double.NaN)) {
//                System.out.println("FU");
//            } else {
//                System.out.println(calculator.calculate(array[1], first, second));
//           }
            try {
                System.out.println(calculator.calculate(array[1], first, second));
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

        }

    }
}


