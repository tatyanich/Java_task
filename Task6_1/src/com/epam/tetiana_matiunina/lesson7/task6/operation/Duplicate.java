package com.epam.tetiana_matiunina.lesson7.task6.operation;




import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/**
 * Created by Tetiana_Matiunina on 29.10.2015.
 */
public class Duplicate implements IOperation {
   // private static final Logger lOGGER = Logger.getLogger(Duplicate.class);

    private String operationName = "3";



    public String getOperationName() {
        return operationName;
    }
    @Override
    public String analyzeTextFile(String filePath) throws FileNotFoundException {
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
        return formatOutputList(duplicateWords).toString();
    }

    private List<String> formatOutputList(List<String> listOfString){
        List<String> list= new ArrayList<String>();


        Collections.sort(listOfString);
        for(String string: listOfString){
            list.add(new StringBuilder(string.toUpperCase()).reverse().toString());
        }


       //Collections.sort(list);
        //Collections.reverse(list);
        return  list;
   //     lOGGER.info(list.toString());
    }
}
