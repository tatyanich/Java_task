package com.epam.tetiana_matiunina.java.task4.lesson4;

/**
 * Created by Tetiana_Matiunina on 21.10.2015.
 */
public class Parser {

//    /**
//     * parse expression string which entered from the console
//     *
//     * @param expressionString String is entered from the console
//     * @return string of array
//     */
    public static String[] parseExpression(String expressionString) {
        String[] arraySymbolsAndNumbers = expressionString.replaceAll("\\s+", "").split("(?<=[-+*/,])|(?=[-+*/,])");
        return arraySymbolsAndNumbers;
    }
}
