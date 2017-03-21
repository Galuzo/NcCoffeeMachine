package by.training.nc.dev3.beans.ingredients;

import by.training.nc.dev3.beans.abstractBeans.AbstractIngredient;

/**
 * Created by Win on 18.03.2017.
 */
public class Chocolate extends AbstractIngredient {
    private double sizeOfPortion;
    public Chocolate()
    {
        this.cost=0.6;
        this.name="Chocolate";
        sizeOfPortion=2;
    }

    @Override
    public String toString() {
        return "Chocolate{" +
                "sizeOfPortion=" + sizeOfPortion +" cost="+cost+
                '}';
    }

    public double getSizeOfPortion() {
        return sizeOfPortion;
    }

    public void setSizeOfPortion(double sizeOfPortion) {
        this.sizeOfPortion = sizeOfPortion;
    }
}
