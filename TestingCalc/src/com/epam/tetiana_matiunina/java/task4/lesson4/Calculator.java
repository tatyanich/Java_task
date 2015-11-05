package com.epam.tetiana_matiunina.java.task4.lesson4;

import com.epam.tetiana_matiunina.java.task4.lesson4.operation.*;


import java.util.*;

/**
 * Created by Tetiana Matiunina on 21.10.2015.
 */
public class Calculator {
    private Map<String, AbstractOperation> mapOperation = new TreeMap<String, AbstractOperation>();

    /**
     * add operation object to Map
     *
     * @param operation  Object of operation
     */
    public void addOperation(AbstractOperation operation) {
        mapOperation.put(operation.getName(), operation);
    }

    /**
     * do the calculation by a given operation
     *
     * @param operatorName operation symbol
     * @param firstNumber number is entered from the console
     * @param secondNumber number is entered from the console
     * @return result of calculation
     */
    public double calculate(String operatorName, double firstNumber, double secondNumber) {
        EMathOperations name = EMathOperations.get(operatorName);
        if (name==null) {
           // System.out.println("Invalid operation");
           throw new IllegalArgumentException("No any operation");
        }
        else{
            try {
            double result = mapOperation.get(operatorName).operate(firstNumber, secondNumber);
            return result;
        } catch (ArithmeticException e) {
          System.out.print(e.getMessage());
           return Double.NaN;
             //   throw  new ArithmeticException("");
        }
//        catch (NullPointerException e){
//          //  System.out.println("FU");
//            return Double.NaN;
//        }
        }

    }
}




