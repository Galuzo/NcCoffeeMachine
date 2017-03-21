package by.training.nc.dev3.beans;

import java.util.Map;

/**
 * Created by Win on 20.03.2017.
 */
public class Instruments {

    public static boolean checkAvailability(Map collection,Object object)
    {
        if(collection.containsKey(object))
            return true;
        else
            return false;
    }

    public static int checkCount(Map collection,Object object) {
        if(checkAvailability(collection,object))
            return (Integer) collection.get(object);
        else
            return 0;
        //Exepction
    }

    public static int decrementValue(Map collection,Object object,int value)
    {
        int currentValue=checkCount(collection,object);
        if(currentValue>0) {
            currentValue-=value;
            return currentValue;
        }
        else
            return 0;

    }

    public static int incrementValue(Map collection,Object object,int value)
    {
        int currentValue=checkCount(collection,object);
        if(currentValue>=0) {
            currentValue+=value;
            return currentValue;
        }
        else
            return 0;

    }
}
