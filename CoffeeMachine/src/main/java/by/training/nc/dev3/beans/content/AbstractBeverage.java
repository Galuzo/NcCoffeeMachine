package by.training.nc.dev3.beans.content;

import by.training.nc.dev3.beans.content.types.TypeBeverage;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Win on 18.03.2017.
 */
public class AbstractBeverage implements Serializable{
    private TypeBeverage typeBeverage;
    private double cost;
    private Set<AbstractIngredient> listOfIngredients=new HashSet<AbstractIngredient>();

    public AbstractBeverage(TypeBeverage typeBeverage, double cost) {
        this.typeBeverage = typeBeverage;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
    public Set<AbstractIngredient> getListOfIngredients() {
        return listOfIngredients;
    }

    public TypeBeverage getTypeBeverage() {
        return typeBeverage;
    }

    public void setTypeBeverage(TypeBeverage typeBeverage) {
        this.typeBeverage = typeBeverage;
    }

    public void setListOfIngredients(Set<AbstractIngredient> listOfIngredients) {
        this.listOfIngredients = listOfIngredients;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Beverage:"
                 + typeBeverage  +
                " cost=" + cost +
                ", Ingredients:" + listOfIngredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractBeverage beverage = (AbstractBeverage) o;

        if (Double.compare(beverage.cost, cost) != 0) return false;
        if (!typeBeverage.equals(beverage.typeBeverage)) return false;
        return listOfIngredients != null ? listOfIngredients.equals(beverage.listOfIngredients) : beverage.listOfIngredients == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = typeBeverage.hashCode();
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (listOfIngredients != null ? listOfIngredients.hashCode() : 0);
        return result;
    }
}
