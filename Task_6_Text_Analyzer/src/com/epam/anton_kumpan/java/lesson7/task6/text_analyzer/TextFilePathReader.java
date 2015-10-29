package com.epam.anton_kumpan.java.lesson7.task6.text_analyzer;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Anton_Kumpan on 10/28/15.
 */
public class TextFilePathReader {
    private Scanner scanner;

    public TextFilePathReader() {
        this.scanner = new Scanner(System.in);
    }

    public String getFilePath() {
        String path = null;
        boolean loop = true;
        while (loop) {
            System.out.println("Enter path to the text file:");
            path = scanner.nextLine();
            File file = new File(path);
            if (file.exists() && !file.isDirectory()) {
                loop = false;
                scanner.close();
            } else {
                System.out.println("No text files found, try again");
            }
        }
        return path;
    }
}
