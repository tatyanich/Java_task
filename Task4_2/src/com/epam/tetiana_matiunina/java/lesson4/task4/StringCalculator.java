package com.epam.tetiana_matiunina.java.lesson4.task4;

import com.epam.tetiana_matiunina.java.lesson4.task4.exception.NullStringException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tetiana_Matiunina on 23.10.2015.
 */
public class StringCalculator {
    private static final String OPEN_BRACKET = "[";
    private static final String MULTIPLY_DELIMITERS = "][";
    private static final String CUSTOM_DELIMITERS_DEFINITION = "//";
    private static final String CLOSE_BRACKET = "]";
    private static final int INDEX_OF_CUSTOM_DELIMITER = 2;

    public List<String> makeStringWithoutDelimiters(String stringWithDelimiters) {
        String delimiter = "[,\\n]";
        int newLineIndex = stringWithDelimiters.indexOf("\n") + 1;
        int delimiterIndex = stringWithDelimiters.indexOf(CUSTOM_DELIMITERS_DEFINITION) + INDEX_OF_CUSTOM_DELIMITER;
        String numbersWithoutDelimiter = stringWithDelimiters.substring(newLineIndex);

        if (!stringWithDelimiters.startsWith(CUSTOM_DELIMITERS_DEFINITION)) {
            return Arrays.asList(stringWithDelimiters.split(delimiter));
        }
        if (stringWithDelimiters.contains(OPEN_BRACKET) && stringWithDelimiters.contains(MULTIPLY_DELIMITERS)) {
            delimiter = defineMultiplyDelimiters(stringWithDelimiters);
            return Arrays.asList(numbersWithoutDelimiter.split(delimiter));
        }
        if (stringWithDelimiters.contains(OPEN_BRACKET)) {
            delimiter = defineDelimitersWithAnyLength(stringWithDelimiters);
            return Arrays.asList(numbersWithoutDelimiter.split(delimiter));
        } else {
            delimiter = stringWithDelimiters.substring(delimiterIndex, delimiterIndex + 1);
            return Arrays.asList(numbersWithoutDelimiter.split(delimiter));
        }
    }


    public String defineMultiplyDelimiters(String stringWithDelimiters) {
        String stringWithDelimiter = stringWithDelimiters.replaceAll("\\]\\[", "");
        int delimitersIndexStart = stringWithDelimiter.indexOf(OPEN_BRACKET);
        int delimitersIndexStartEnd = stringWithDelimiter.indexOf(CLOSE_BRACKET) + 1;
        String delimiter = stringWithDelimiter.substring(delimitersIndexStart, delimitersIndexStartEnd);
        return delimiter;
    }

    public String defineDelimitersWithAnyLength(String stringWithDelimiters) {
        String delimiter;
        int delimiterIndex = stringWithDelimiters.indexOf(OPEN_BRACKET) + INDEX_OF_CUSTOM_DELIMITER;
        delimiter = OPEN_BRACKET + stringWithDelimiters.substring(delimiterIndex, delimiterIndex + 1) + CLOSE_BRACKET + "+";
        return delimiter;
    }


    public int add(String str) throws IllegalArgumentException, NullStringException {
        if(str != null){
        List<String> arrayOfNumbers = makeStringWithoutDelimiters(str);
        List<String> negativeNumber = new ArrayList<String>();
        if (str.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (String summand : arrayOfNumbers) {
            if (Integer.valueOf(summand) > 1000) {
                continue;
            }
            if (Integer.valueOf(summand) < 0) {
                negativeNumber.add(summand);
            } else {
                sum += Integer.valueOf(summand);
            }
        }
        if (negativeNumber.isEmpty()) {
            return sum;
        } else {
            System.out.println("negatives not allowed: " + negativeNumber.toString());
            throw new IllegalArgumentException("negatives not allowed: " + negativeNumber.toString());

        }
        }else {
            throw new NullStringException("string couldn't be null!");
        }
    }
}