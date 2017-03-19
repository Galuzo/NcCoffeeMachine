package by.training.nc.dev3.beans;

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
        }
        for(AbstractIngredient ingredient:bill.getIngredients())
            resultCost+=ingredient.getCost();
    }

    public double getResultCost() {
        return resultCost;
    }
}
