package by.training.nc.dev3.instruments;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by Win on 26.03.2017.
 */
public class FileWorker {


    public static void writeLogger(String data) {
        File file = new File("src"+File.separator+"main"+File.separator+"resources"+File.separator+"logger");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file,true);

            fr.append(data+": "+ Calendar.getInstance().getTime()+"\n");
        } catch (IOException e) {
            System.out.println("Unsuccessful opening of the file");
        }finally{
            try {
                fr.close();
            } catch (IOException e) {
                System.out.println("File doesn`t close");
            }
        }
    }
}
