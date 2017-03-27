package by.training.nc.dev3.beans.abstractions;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Win on 18.03.2017.
 */
public class AbstractBeverage implements Serializable{
    protected String name;
    protected double cost;
    protected Set<AbstractIngredient> listOfIngredients=new HashSet<AbstractIngredient>();

    public String getName() {
        return name;
    }
    public double getCost() {
        return cost;
    }
    public Set<AbstractIngredient> getListOfIngredients() {
        return listOfIngredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        AbstractBeverage that = (AbstractBeverage) o;

        if (Double.compare(that.cost, cost) != 0)
        {
            return false;
        }
        if (!name.equals(that.name))
        {
            return false;
        }
        return listOfIngredients != null ? listOfIngredients.equals(that.listOfIngredients) : that.listOfIngredients == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (listOfIngredients != null ? listOfIngredients.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Beverage:"
                 + name  +
                " cost=" + cost +
                ", Ingredients:" + listOfIngredients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}