package by.training.nc.dev3.beans.abstractBeans;

import java.util.ArrayList;
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

    public void removeIngredient(AbstractIngredient abstractIngredient)
    {
        if(listOfIngredients.contains(abstractIngredient))
            listOfIngredients.remove(abstractIngredient);
    }

    public void removeAllIngredients()
    {
        listOfIngredients = new ArrayList<AbstractIngredient>();
    }

    public List<AbstractIngredient> getListOfIngredients() {
        return listOfIngredients;
    }

    public String showIngredients()
    {
        String allIngredients="";
        for(AbstractIngredient ingredient:listOfIngredients)
        {
            allIngredients += "+";
            allIngredients+=ingredient.getDescription();

        }
        return  allIngredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractBeverage that = (AbstractBeverage) o;

        if (Double.compare(that.cost, cost) != 0) return false;
        if (!description.equals(that.description)) return false;
        return listOfIngredients != null ? listOfIngredients.equals(that.listOfIngredients) : that.listOfIngredients == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = description.hashCode();
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (listOfIngredients != null ? listOfIngredients.hashCode() : 0);
        return result;
    }




    @Override
    public String toString() {
        return description;
    }
}
