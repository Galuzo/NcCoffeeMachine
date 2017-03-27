package by.training.nc.dev3.beans.abstractions;

import java.io.Serializable;

/**
 * Created by Win on 18.03.2017.
 */
public class AbstractIngredient implements Serializable {
    protected String name;
    protected double cost;

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", cost=" + cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        AbstractIngredient that = (AbstractIngredient) o;

        if (Double.compare(that.cost, cost) != 0)
        {
            return false;
        }
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


}
