package com.epam.tetiana_matiunina.lesson7.task6;

import com.epam.tetiana_matiunina.lesson7.task6.operation.Duplicate;
import com.epam.tetiana_matiunina.lesson7.task6.operation.Frequency;
import com.epam.tetiana_matiunina.lesson7.task6.operation.Length;
import com.epam.tetiana_matiunina.lesson7.task6.operation.OperationManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Tetiana_Matiunina on 28.10.2015.
 */
public class TextReader {
    private static OperationManager operationManager;

    public static void init() {
        operationManager = new OperationManager();
        operationManager.setOperation(new Frequency());
        operationManager.setOperation(new Length());
        operationManager.setOperation(new Duplicate());
    }


   public static void main(String[] args) throws IOException {


       init();
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
            switch (operation.charAt(0)){
                case '1':
                    String s = operationManager.getOperation(path, operation);
                    System.out.println(s);
                    loop = false;
                    break;
                case '2':
                    System.out.println(operationManager.getOperation(path,operation));
                    loop = false;
                    break;
                case '3':
                    System.out.println(operationManager.getOperation(path,operation));
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid operation !");
            }

//            if ((operation.charAt(0) == '1') || (operation.charAt(0) == '2') || (operation.charAt(0) == '3')) {
//                loop = false;
//                S
//                Frequency frequency = new Frequency();
//                System.out.println(frequency.analyzeTextFile(path));
//                Length length = new Length();
//                System.out.println(length.analyzeTextFile(path));
//                 Duplicate duplicate = new Duplicate();
//                System.out.println(duplicate.analyzeTextFile(path));
//            } else {
//                System.out.println("Invalid operation statement!");
//            }

        }


    }
}

