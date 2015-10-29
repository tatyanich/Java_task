package com.epam.tetiana_matiunina.lesson7.task6.operation;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Администратор on 29.10.2015.
 */
public class OperationManager {

    private Map<String, IOperation> mapOfOperation = new HashMap<String, IOperation>();
   // private IOperation iOperation;

    public void setOperation(IOperation iOperation){
        mapOfOperation.put(iOperation.getOperationName(),iOperation);

    }

    public String getOperation(String path, String operation) throws FileNotFoundException {

        return mapOfOperation.get(operation).analyzeTextFile(path) ;
    }

}
