package by.training.nc.dev3.beans.beverages;

import by.training.nc.dev3.beans.abstractions.AbstractBeverage;

/**
 * Created by Win on 18.03.2017.
 */
public class Latte extends AbstractBeverage {
    private double countOfMilk;
    public Latte()
    {
        name = "Latte";
        cost=1.9;
        countOfMilk=50;
    }

    public double getCountOfMilk() {
        return countOfMilk;
    }

    public void setCountOfMilk(double countOfMilk) {
        this.countOfMilk = countOfMilk;
    }
}
