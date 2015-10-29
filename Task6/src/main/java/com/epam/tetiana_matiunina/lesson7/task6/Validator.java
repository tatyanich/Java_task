package com.epam.tetiana_matiunina.lesson7.task6;

import java.io.File;
import java.io.IOException;

/**
 * Created by Tetiana_Matiunina on 28.10.2015.
 */
public class Validator {

    public boolean validatePathString(String path) throws IOException {
        File f = new File(path);
        try {
            f.getCanonicalPath();
            return true;
        }
        catch (IOException e) {
            return false;
        }
    }

    public boolean validateFileExist(String path) {
        File file = new File(path);
        if (file.exists() && !file.isDirectory()) {
            return true;

        } else {
            return false;
        }
    }



}
