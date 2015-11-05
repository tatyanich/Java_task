package com.epam.tetiana_matiunina.java.task4.lesson4.operation;

import java.util.List;

/**
 * Created by Tetiana_Matiunina on 26.10.2015.
 */
public enum EMathOperations {
    SUM("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/");


    private final String mathOperations;


    private EMathOperations(String mathOperations) {
        this.mathOperations = mathOperations;
    }

    public String getMathOperations() {
        return mathOperations;
    }

    /**
     * returns an operation if it exist in enum
     *
     * @param operationName input mathematical operation
     * @return null if no such input operation will not found in enum of operations, else return operation;
     */
    public static EMathOperations get(String operationName) {
        EMathOperations operation = null;
        for (EMathOperations str : EMathOperations.values()) {
            if (str.mathOperations.equals(operationName)) {
                operation = str;
            }
        }
        return operation;
    }
}
