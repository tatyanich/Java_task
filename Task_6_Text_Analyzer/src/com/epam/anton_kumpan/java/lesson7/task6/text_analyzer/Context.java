package com.epam.anton_kumpan.java.lesson7.task6.text_analyzer;

import java.util.List;

/**
 * Created by Anton_Kumpan on 29.10.2015.
 */
public class Context {
    private Operation operation;

    public Context() {
    }
    public void setStrategy(Operation operation) {
        this.operation = operation;
    }
    public List<String> executeStrategy() {
        return operation.findWordsDependingOnContext();
    }
}
