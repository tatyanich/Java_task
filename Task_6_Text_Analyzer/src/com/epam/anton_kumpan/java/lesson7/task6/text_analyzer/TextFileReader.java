package com.epam.anton_kumpan.java.lesson7.task6.text_analyzer;


import java.util.List;

/**
 * Created by Anton_Kumpan on 10/28/15.
 */
public class TextFileReader  {

    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new ConcreteOperationLength());
        List<String> a = context.executeStrategy();
        System.out.println(a.toString());
       //Operation operation = new Operation(new ConcreteOperationFrequency());

       // System.out.println(textFileOperator.findSelectedAmountOfWordsWithHighestLength());
    }
}
