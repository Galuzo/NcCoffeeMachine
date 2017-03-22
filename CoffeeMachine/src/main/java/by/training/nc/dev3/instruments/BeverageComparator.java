package by.training.nc.dev3.instruments;

import by.training.nc.dev3.beans.abstractions.AbstractBeverage;
import by.training.nc.dev3.beans.abstractions.AbstractIngredient;

import java.util.Comparator;

/**
 * Created by Win on 22.03.2017.
 */
public class BeverageComparator implements Comparator<AbstractBeverage> {
    public int compare(AbstractBeverage o1, AbstractBeverage o2) {
        if(o1.getCost()>o2.getCost()) {
            return 1;
        }
        else if(o1.getCost()<o2.getCost())
        {
            return -1;
        }
        else
        {
            return 0;
        }

    }
}
