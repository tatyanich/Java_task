package com.epam.anton_kumpan.java.lesson7.task6.text_analyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Anton_Kumpan on 29.10.2015.
 */
public abstract class Operation {
    private TextFilePathReader textFilePathReader;
    public HashMap<String, Integer> wordsStatistics;
    public Scanner scanner;

    public abstract List<String> findWordsDependingOnContext();
    public abstract String findAllWords();

    public Scanner fileScanner() {
        textFilePathReader = new TextFilePathReader();
        try {
            scanner = new Scanner(new File(textFilePathReader.getFilePath()));
        } catch (FileNotFoundException e) {
            //TODO
            e.printStackTrace();
        }
        return scanner;
    }

}
