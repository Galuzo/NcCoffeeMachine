package by.training.nc.dev3.services;

import by.training.nc.dev3.beans.content.AbstractBeverage;
import by.training.nc.dev3.beans.content.AbstractIngredient;
import by.training.nc.dev3.beans.outputs.Bill;
import by.training.nc.dev3.interfaces.Calculateble;

/**
 * Created by Win on 19.03.2017.
 */
public class BillCalculator implements Calculateble {
    public void calculate(Bill bill)
    {
        double resultCost=0;
        for(AbstractBeverage beverage:bill.getBeverages())
        {
            resultCost+=beverage.getCost();
            for(AbstractIngredient ingredient:beverage.getListOfIngredients())
                resultCost+=ingredient.getCost();
        }
        bill.setGeneralCost(resultCost);
    }


}
