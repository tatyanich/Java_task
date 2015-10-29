package com.epam.anton_kumpan.java.lesson7.task6.text_analyzer;

import java.util.*;

/**
 * Created by Anton_Kumpan on 29.10.2015.
 */
public class ConcreteOperationLength extends Operation {
    private Map.Entry<String, Integer> recordWithMaxLength;
    private List<String> listOfWordsWithHighestLength;
    private final int AMOUNT_OF_WORDS_WITH_HIGHEST_LENGTH = 3;

    @Override
    public List<String> findWordsDependingOnContext() {
        findAllWords();
        listOfWordsWithHighestLength = new ArrayList<String>();
        for (int i = 0; i < AMOUNT_OF_WORDS_WITH_HIGHEST_LENGTH; i++) {
            recordWithMaxLength = findRecordWithMaxLength();
            listOfWordsWithHighestLength.add(recordWithMaxLength.getKey() + " => " + recordWithMaxLength.getKey().length());
            wordsStatistics.remove(recordWithMaxLength.getKey());
            recordWithMaxLength = null;
        }
        return listOfWordsWithHighestLength;
    }

    @Override
    public String findAllWords() {
        fileScanner();
        wordsStatistics = new HashMap<String, Integer>();
        while (scanner.hasNext()) {
            String word = scanner.useDelimiter(("\\s+")).next();
            wordsStatistics.put(word, word.length());
        }
        return wordsStatistics.toString();
    }

    private Map.Entry<String, Integer> findRecordWithMaxLength() {
        for (Map.Entry<String, Integer> entry : wordsStatistics.entrySet()) {
            if (recordWithMaxLength == null || entry.getValue().compareTo(recordWithMaxLength.getValue()) > 0) {
                recordWithMaxLength = entry;
            }
        }
        return recordWithMaxLength;
    }
}
