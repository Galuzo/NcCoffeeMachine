package by.training.nc.dev3.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Win on 18.03.2017.
 */
public class AbstractBeverage {
    protected String description;
    protected double cost;
    protected List<AbstractIngredient> listOfIngredients=new ArrayList();

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public void AddIngredient(AbstractIngredient abstractIngredient)
    {
        listOfIngredients.add(abstractIngredient);
    }

    public void removeIngredients(AbstractIngredient abstractIngredient)
    {
        if(listOfIngredients.contains(abstractIngredient))
            listOfIngredients.remove(abstractIngredient);
    }

    public void showIngredients()
    {
        for(AbstractIngredient ingredient:listOfIngredients)
        {
            System.out.println(ingredient);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractBeverage that = (AbstractBeverage) o;

        if (Double.compare(that.cost, cost) != 0) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = description.hashCode();
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return description;
    }
}
