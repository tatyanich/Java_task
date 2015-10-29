package com.epam.tetiana_matiunina.lesson7.task6.operation;


import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Tetiana_Matiunina on 29.10.2015.
 */
public class Duplicate implements IOperation {
    private static final Logger lOGGER = Logger.getLogger(Duplicate.class);
    @Override
    public void analyzeTextFile(String filePath) throws FileNotFoundException {
        Map<String, Integer> statistics;
        List<String> duplicateWords= new ArrayList<String>();
        Scanner scanner = new Scanner(new File(filePath));
        statistics = new TreeMap<String, Integer>(Collections.reverseOrder());
        while (scanner.hasNext()) {
            String word = scanner.useDelimiter("\\s+").next();
            Integer count = statistics.get(word);
            if (count == null) {
                count = 0;
            }
            statistics.put(word, ++count);
            if(count==2){
                    duplicateWords.add(word);
            }
            if(duplicateWords.size() == 3){
                break;
            }
        }
        scanner.close();
        formatOutputList(duplicateWords);
    }

    private static void formatOutputList(List<String> listOfString){
        List<StringBuilder> list = listOfString.stream().map(str -> new StringBuilder(str.toUpperCase()).reverse()).collect(Collectors.toList());

        //Collections.sort(listOfString);
        Collections.reverse(list);
        lOGGER.info(list.toString());
    }
}
