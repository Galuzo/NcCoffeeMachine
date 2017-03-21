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
    public List<AbstractBeverage> getBeverages() {
        return beverages;
    }

}
