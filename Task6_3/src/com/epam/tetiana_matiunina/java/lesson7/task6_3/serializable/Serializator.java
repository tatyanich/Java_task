package com.epam.tetiana_matiunina.java.lesson7.task6_3.serializable;

import com.epam.tetiana_matiunina.java.lesson7.task6_3.airplane.Airplane;
import com.epam.tetiana_matiunina.java.lesson7.task6_3.airplane.models.Boeing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Tetiana_Matiunina on 29.10.2015.
 */
public class Serializator {


    public void serializeAirplane(String path, Airplane airplane) throws IOException {
        ObjectOutput output = null;
        try {
            OutputStream file = new FileOutputStream(path);
            OutputStream buffer = new BufferedOutputStream(file);
            output = new ObjectOutputStream(buffer);
            output.writeObject(airplane);
        } catch (IOException ex) {
            Logger.getLogger(Serializator.class.toString()).log(Level.SEVERE, "Couldn't write object");
        } finally {
            if (output != null) {
                output.close();
            }
        }

    }

    public void deSerializeAirplane(String path) throws IOException {
        ObjectInput input = null;
        try {
            InputStream file = new FileInputStream(path);
            InputStream buffer = new BufferedInputStream(file);
            input = new ObjectInputStream(buffer);
            Airplane recoveredAirplane = (Airplane) input.readObject();
            System.out.println("Recovered airplane: " + recoveredAirplane);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Serializator.class.toString()).log(Level.SEVERE, ex.getMessage());

        } finally {
            if (input != null) {
                input.close();
            }
        }
    }


    public static void main(String[] args) {
        Boeing boeing = new Boeing("Boeing474", 3.0, 7.9, 9);
        Boeing boeing1 = new Boeing("Boeing475", 8.0, 7.4, 200);
        Boeing boeing2 = new Boeing("Boeing478", 7.0, 30.9, 100);
        Serializator serializator = new Serializator();
        try {
            serializator.serializeAirplane("output.txt", boeing);
            serializator.serializeAirplane("output1.txt", boeing1);
            serializator.serializeAirplane("output2.txt", boeing2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            serializator.deSerializeAirplane("outpdfgdut.txt");
            serializator.deSerializeAirplane("output1.txt");
            serializator.deSerializeAirplane("output2.txt");
        } catch (IOException e) {
            Logger.getLogger(Serializator.class.toString()).log(Level.INFO, e.getMessage());
        }
    }


}
