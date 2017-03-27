package by.training.nc.dev3.instruments;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Win on 25.03.2017.
 */
public class InputData {
    public static Scanner input = new Scanner(System.in);

    public static int inputNumber(){
        int number = -1;
        while(number < 0){
            try {
                input = new Scanner(System.in);
                number = input.nextInt();
                if(number >= 0){
                    return number;
                }
                else{
                    System.out.println("number cannot be negative. Try again...");
                    FileWorker.writeLogger("number cannot be negative. Try again...");
                    continue;
                }

            }
            catch (InputMismatchException e) {
                System.out.println("Incorrect format. Try again...");
                FileWorker.writeLogger("Incorrect format. Try again...");
                continue;
            }
        }
        return 0;
    }

}
