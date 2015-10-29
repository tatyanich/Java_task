package com.epam.tetiana_matiunina.lesson7.task6.operation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Tetiana_Matiunina on 29.10.2015.
 */
public class Length implements IOperation {
    private static final int WORDS_WITH_MAX_LENGTH= 3;

    @Override
    public void analyzeTextFile(String filePath) throws FileNotFoundException {
        Map<String, Integer> statistics;

        Scanner scanner = new Scanner(new File(filePath));
        statistics = new TreeMap<String, Integer>(Collections.reverseOrder());
        while (scanner.hasNext()) {
            String word = scanner.useDelimiter("\\s+").next();
            statistics.put(word, word.length());
        }
        scanner.close();
        findMaxWordsWithDuplicate(statistics);

    }

    private static void findMaxWordsWithDuplicate(Map<String, Integer> mapOfString) {

        List<String> stringsWithMaxDuplicate = new ArrayList<String>();
        Map.Entry<String, Integer> max;

        for (int i = 0; i < WORDS_WITH_MAX_LENGTH; i++) {
            max = null;
            for (Map.Entry<String, Integer> map : mapOfString.entrySet()) {
                if (max == null || map.getValue().compareTo(max.getValue()) > 0) {
                    max = map;
                }
            }
            stringsWithMaxDuplicate.add(max.getKey() + " => " + max.getValue());
            mapOfString.remove(max.getKey());

        }
        //Comparator comparator = Collections.reverseOrder();
        //Collections.sort(stringsWithMaxDuplicate);
        System.out.println(stringsWithMaxDuplicate.toString());
    }
}
