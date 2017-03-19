package by.training.nc.dev3.beans.bill;

import by.training.nc.dev3.beans.abstractBeans.AbstractBeverage;
import by.training.nc.dev3.beans.abstractBeans.AbstractIngredient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Win on 19.03.2017.
 */
public class Bill {
   private List<AbstractBeverage> beverages = new ArrayList<AbstractBeverage>();

   public void addBeverageInBill(AbstractBeverage beverage) {
        beverages.add(beverage);
    }

    public boolean billContainBeverage(AbstractBeverage beverage) {
        if(beverages.contains(beverage))
            return true;
        else
            return false;
    }

    public void removeBeverageFromBill(AbstractBeverage beverage) {
        beverages.remove(beverage);
    }

    public void showResultBill() {
        if(!beverages.isEmpty())
            for (AbstractBeverage beverage : beverages) {
                System.out.println("beverage:"+beverage.getDescription()+beverage.showIngredients());
            }
    }

    public List<AbstractBeverage> getBeverages() {
        return beverages;
    }

}
