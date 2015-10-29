package com.epam.tetiana_matiunina.java.lesson7.task6_3.serializable;

import com.epam.tetiana_matiunina.java.lesson7.task6_3.airplane.Airplane;
import com.epam.tetiana_matiunina.java.lesson7.task6_3.airplane.models.Boeing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by Tetiana_Matiunina on 29.10.2015.
 */
public class Serializator {


    public void serializeAirplane(String path, Airplane airplane) throws IOException {

        try (OutputStream file = new FileOutputStream(path);
             OutputStream buffer = new BufferedOutputStream(file);
             ObjectOutput output = new ObjectOutputStream(buffer);) {
            output.writeObject(airplane);
        } catch (IOException ex) {

            throw new IOException("Couldn't write object");
        }

    }

    public void deSerializeAirplane(String path) throws IOException {

        try (InputStream file = new FileInputStream(path);
             InputStream buffer = new BufferedInputStream(file);
             ObjectInput input = new ObjectInputStream(buffer);) {
            //use buffering

            Airplane airplane = (Airplane) input.readObject();

            //deserialize the List
//            List<Airplane> recoveredAirplane = (List<Airplane>) input.readObject();
//            //display its data
//            for (Airplane quark : recoveredAirplane) {
               System.out.println("Recovered Quark: " + airplane);
//
//            }
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
            //fLogger.log(Level.SEVERE, "Cannot perform input. Class not found.", ex);
        } catch (IOException ex) {
            throw new IOException("Couldn't write object");
           // fLogger.log(Level.SEVERE, "Cannot perform input.", ex);
        } finally {
           // input.close();
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
            serializator.deSerializeAirplane("output.txt");
            serializator.deSerializeAirplane("output1.txt");
            serializator.deSerializeAirplane("output2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
