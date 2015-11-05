package com.epam.tetiana_matiunina.java.task4.lesson4.operation;

/**
 * Created by Tetiana Matiunina on 21.10.2015.
 */
public abstract class AbstractOperation {

    private String operationName;

    public AbstractOperation(String operationName) {
        this.operationName = operationName;
    }

    public String getName() {
        return operationName;
    }

    /**
     * do mathematical operation
     *
     * @param firstNumber  number is entered from the console
     * @param secondNumber number is entered from the console
     * @return result of operation
     *
     */
    public abstract double operate(double firstNumber, double secondNumber);

}
