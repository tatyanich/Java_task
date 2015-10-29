package com.epam.anton_kumpan.java.lesson7.task6.text_analyzer;

import java.util.*;

/**
 * Created by Anton_Kumpan on 29.10.2015.
 */
public class ConcreteOperationFrequency extends Operation {
    private Map.Entry<String, Integer> recordWithMaxFrequency;
    private List<String> listOfWordsWithHighestFrequency;
    private final int AMOUNT_OF_WORDS_WITH_HIGHEST_FREQUENCY = 2;

    @Override
    public List<String> findWordsDependingOnContext() {
        findAllWords();
        listOfWordsWithHighestFrequency = new ArrayList<String>();
        for (int i = 0; i < AMOUNT_OF_WORDS_WITH_HIGHEST_FREQUENCY; i++) {
            recordWithMaxFrequency = findRecordWithMaxFrequency();
            listOfWordsWithHighestFrequency.add(recordWithMaxFrequency.getKey() + " => " + recordWithMaxFrequency.getValue());
            wordsStatistics.remove(recordWithMaxFrequency.getKey());
            recordWithMaxFrequency = null;
        }
        Comparator reverseOrder = Collections.reverseOrder();
        Collections.sort(listOfWordsWithHighestFrequency, reverseOrder);
        return listOfWordsWithHighestFrequency;
    }

    @Override
    public String findAllWords() {
        fileScanner();
        wordsStatistics = new HashMap<String, Integer>();
        while (scanner.hasNext()) {
            String word = scanner.useDelimiter(("\\s+")).next();
            Integer count = wordsStatistics.get(word);
            if (count == null) {
                count = 0;
            }
            wordsStatistics.put(word, ++count);
        }
        return wordsStatistics.toString();
    }

    private Map.Entry<String, Integer> findRecordWithMaxFrequency() {
        for (Map.Entry<String, Integer> entry : wordsStatistics.entrySet()) {
            if (recordWithMaxFrequency == null || entry.getValue().compareTo(recordWithMaxFrequency.getValue()) > 0) {
                recordWithMaxFrequency = entry;
            }
        }
        return recordWithMaxFrequency;
    }
}
