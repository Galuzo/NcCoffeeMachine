package by.training.nc.dev3.beans.bill;

import by.training.nc.dev3.beans.abstractBeans.AbstractBeverage;
import by.training.nc.dev3.beans.abstractBeans.AbstractIngredient;

/**
 * Created by Win on 19.03.2017.
 */
public class BillCalculator {
    private double resultCost;
    public void calculate(Bill bill)
    {
        for(AbstractBeverage beverage:bill.getBeverages())
        {
            resultCost+=beverage.getCost();
            for(AbstractIngredient ingredient:beverage.getListOfIngredients())
                resultCost+=ingredient.getCost();
        }
    }

    public double getResultCost() {
        return resultCost;
    }
}
