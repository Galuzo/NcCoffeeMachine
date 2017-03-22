package by.training.nc.dev3.beans.outputs;

import by.training.nc.dev3.beans.abstractions.AbstractBeverage;

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
