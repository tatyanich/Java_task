package com.epam.tetiana_matiunina.java.task4.lesson4.operation;

/**
 * Created by Tetiana Matiunina on 21.10.2015.
 */
public class Addition extends AbstractOperation {


    public Addition() {
        super(EMathOperations.SUM.getMathOperations());
    }

    /**
     * adds two numbers
     * @param firstNumber  number is entered from the console
     * @param secondNumber number is entered from the console
     * @return result of addition
     */
    @Override
    public double operate(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }
}
