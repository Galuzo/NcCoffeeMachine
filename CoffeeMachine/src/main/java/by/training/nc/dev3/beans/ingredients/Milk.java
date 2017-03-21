package by.training.nc.dev3.beans.ingredients;

import by.training.nc.dev3.beans.abstractBeans.AbstractIngredient;

/**
 * Created by Win on 19.03.2017.
 */
public class Milk extends AbstractIngredient {
    private double fatiness;
    public Milk() {
        this.name = "Milk";
        this.cost=0.6;
        fatiness=3.2;
    }

    public double getFatiness() {
        return fatiness;
    }

    public void setFatiness(double fatiness) {
        this.fatiness = fatiness;
    }

    @Override
    public String toString() {
        return "Milk{" +
                "fatiness=" + fatiness +" cost="+cost+
                '}';
    }
}
