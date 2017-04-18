package by.training.nc.dev3.instruments;

import by.training.nc.dev3.beans.ContentInBill;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by Win on 14.04.2017.
 */
public class BillWorkHelper {
    public static ContentInBill getBeverageWithIngredient(List<ContentInBill> list ,int compareId)
    {
       for(ContentInBill content:list)
       {
           if(content.getIdIngredient()==compareId)
           {
               return content;
           }
       }
       return null;
    }

    public static ContentInBill incrementEmptyBeverage(List<ContentInBill> beverageInBill,int compareId)
    {
        ContentInBill emptyBeverage=BillWorkHelper.getBeverageWithIngredient(beverageInBill,compareId);
        if(emptyBeverage!=null) {
            int currentValue = emptyBeverage.getBeverageCount();
            currentValue = Instruments.incrementValue(currentValue, 1);
            emptyBeverage.setBeverageCount(currentValue);
            return emptyBeverage;
        }
        else
        {
            return null;
        }
    }
}
