package by.training.nc.dev3.instruments;

import by.training.nc.dev3.exceptions.IncorrectValue;
import by.training.nc.dev3.exceptions.NotFoundException;

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

    public static int checkCount(Map collection,Object object) throws NotFoundException {
        if(checkAvailability(collection,object))
            return (Integer) collection.get(object);
        else
           throw new NotFoundException("Element not found in machines(",object);

    }

    public static int decrementValue (Map collection,Object object,int value) throws NotFoundException,IncorrectValue
    {
        int currentValue= 0;
        try {
            currentValue = checkCount(collection,object);
        } catch (NotFoundException e) {
            throw  new NotFoundException(e.getMessage(),e.getElement());
        }
        if(currentValue>0) {
            currentValue-=value;
            return currentValue;
        }
        else
            throw new IncorrectValue("Incorrect value",object);

    }

    public static int incrementValue(Map collection,Object object,int value) throws NotFoundException,IncorrectValue
    {
        int currentValue= 0;
        try {
            currentValue = checkCount(collection,object);

        } catch (NotFoundException e) {
            throw  new NotFoundException(e.getMessage(),e.getElement());
        }
        if(currentValue>=0) {
            currentValue+=value;
            return currentValue;
        }
        else
            throw new IncorrectValue("Incorrect value",object);



    }
}
