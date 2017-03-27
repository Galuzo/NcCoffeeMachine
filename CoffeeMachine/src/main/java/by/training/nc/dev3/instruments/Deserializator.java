package by.training.nc.dev3.instruments;

import by.training.nc.dev3.beans.persons.Client;

import java.io.*;

/**
 * Created by Win on 27.03.2017.
 */
public class Deserializator {
   static public Object deserialization(String fileName) throws InvalidObjectException {
        File file = new File(fileName);
        FileInputStream fileInputStream ;
        ObjectInputStream objectInputStream=null;
        try {
            fileInputStream = new FileInputStream(file);
            if(fileInputStream!=null)
            {
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    try {
                        Object Object=objectInputStream.readObject();
                        return Object;
                    } catch (ClassNotFoundException e) {
                        System.out.println("Class doesn`t exist");
                    }
                } catch (IOException e) {
                    System.out.println("Error"+e);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("file was not found by deserialization");
            FileWorker.writeLogger("file was not found by deserialization");
        }
         finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing file");
                FileWorker.writeLogger("Error closing file");
            }
        }
        throw new InvalidObjectException("Object didn`t create");
    }
}
