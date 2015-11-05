package com.epam.tetiana_matiunina.java.task4.lesson4.operation;

/**
 * Created by Tetiana Matiunina on 21.10.2015.
 */
public class Division extends AbstractOperation {

    public Division() {
        super(EMathOperations.DIVIDE.getMathOperations());
    }
    /**
     * divides two numbers
     * @param firstNumber  number is entered from the console
     * @param secondNumber number is entered from the console
     * @return result of division
     */
    @Override
    public double operate(double firstNumber, double secondNumber) throws ArithmeticException {
        if (secondNumber == 0) {
            throw new ArithmeticException("Divided by zero is impossible ");
        } else {
            return firstNumber / secondNumber;
        }
    }


}
