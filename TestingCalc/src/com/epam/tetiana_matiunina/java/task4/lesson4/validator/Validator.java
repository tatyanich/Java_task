package com.epam.tetiana_matiunina.java.task4.lesson4.validator;

import com.epam.tetiana_matiunina.java.task4.lesson4.operation.EMathOperations;

/**
 * Created by Tetiana_Matiunina on 26.10.2015.
 */
public class Validator {
    /**
     * validates expression string on valid operands and operator
     *
     * @param args argument of expression from console
     * @return exception message if it has, and empty string if it no
     */
    public static String validate(String[] args) {
        EMathOperations[] operations = EMathOperations.values();
        String operatorsCheck = operations[0].getMathOperations() + operations[1].getMathOperations()
                + operations[2].getMathOperations() + operations[3].getMathOperations();
        if (args.length < 3) {
            return "Invalid mathematical expression. It must be number operand number.Possible operands: " + operatorsCheck;
        }
        if (args.length > 3) {
            return "Invalid mathematical expression. Can calculate only two positive numbers";
        }
        if (args.length == 3) {
            try {
                checkVariable(args[0]);
                checkVariable(args[2]);
            } catch (NumberFormatException e) {
                return e.getMessage();
            }
        }
        return "";
    }

    /**
     * checks input string for number, throw exception if it not a number
     *
     * @param number string is entered from the console
     */
    private static void checkVariable(String number) {
        try {
            Double.valueOf(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid operator " + number);
        }
    }
}
