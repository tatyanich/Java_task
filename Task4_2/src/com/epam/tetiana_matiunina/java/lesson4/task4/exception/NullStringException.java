package com.epam.tetiana_matiunina.java.lesson4.task4.exception;

/**
 * Created by Tetiana_Matiunina on 05.11.2015.
 */
public class NullStringException extends Exception {
    private String message = null;

     public NullStringException(String message) {
        super(message);
        this.message = message;
    }

   @Override
    public String toString() {
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
