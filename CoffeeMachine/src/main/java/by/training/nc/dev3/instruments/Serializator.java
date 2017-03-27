package by.training.nc.dev3.instruments;

import by.training.nc.dev3.beans.persons.Client;

import java.io.*;

/**
 * Created by Win on 27.03.2017.
 */
public class Serializator {
    static public void serialization(Object object,String fileName)
    {
        File file = new File(fileName);
        ObjectOutputStream objectOutputStream=null;
        if (file.exists()) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                if(fileOutputStream!=null)
                {
                    try {
                        objectOutputStream = new ObjectOutputStream(fileOutputStream);
                        objectOutputStream.writeObject(object);
                    } catch (IOException e) {
                        System.out.println("Error serialize");
                        FileWorker.writeLogger("Error serialize");
                    }

                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                FileWorker.writeLogger("File not found");

            }
            finally {
                    if(objectOutputStream!=null)
                    {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e) {
                            System.out.println("Error closing");
                            FileWorker.writeLogger("Error closing");
                        }
                    }

            }

        }
    }

}
