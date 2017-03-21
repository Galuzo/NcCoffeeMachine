package by.training.nc.dev3.services;

import by.training.nc.dev3.beans.abstractBeans.AbstractBeverage;
import by.training.nc.dev3.beans.abstractBeans.AbstractIngredient;
import by.training.nc.dev3.beans.bill.Bill;

/**
 * Created by Win on 19.03.2017.
 */
public class BillCalculator {
    public double calculate(Bill bill)
    {
        double resultCost=0;
        for(AbstractBeverage beverage:bill.getBeverages())
        {
            resultCost+=beverage.getCost();
            for(AbstractIngredient ingredient:beverage.getListOfIngredients())
                resultCost+=ingredient.getCost();
        }
        return resultCost;
    }


}
