package com.epam.tetiana_matiunina.lesson7.task6;

import com.epam.tetiana_matiunina.lesson7.task6.operation.Duplicate;
import com.epam.tetiana_matiunina.lesson7.task6.operation.Frequency;
import com.epam.tetiana_matiunina.lesson7.task6.operation.Length;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Tetiana_Matiunina on 28.10.2015.
 */
public class TextReader {

   public static void main(String[] args) throws IOException {


        Scanner scanner = new Scanner(System.in);
        String path = "";
        Validator validator = new Validator();
        boolean loop = true;
        while (loop) {
            System.out.println("Please enter path to file: ");
            path = scanner.nextLine();
            if (!validator.validatePathString(path)) {
                System.out.println("Invalid path!");
            } else if (!validator.validateFileExist(path)) {
                System.out.println("File doesn't exist!");
            } else {
                loop = false;
            }
        }
        loop = true;
        while (loop) {
            System.out.println("Please enter an operation, what you want to do with file:");
            System.out.println("1-frequency, 2-length, 3-duplicates");
            String operation = scanner.nextLine();
            if ((operation.charAt(0) == '1') || (operation.charAt(0) == '2') || (operation.charAt(0) == '3')) {
                loop = false;
                Frequency frequency = new Frequency();
                frequency.analyzeTextFile(path);
                Length length = new Length();
                length.analyzeTextFile(path);
                 Duplicate duplicate = new Duplicate();
                duplicate.analyzeTextFile(path);
            } else {
                System.out.println("Invalid operation statement!");
            }

        }


    }
}

