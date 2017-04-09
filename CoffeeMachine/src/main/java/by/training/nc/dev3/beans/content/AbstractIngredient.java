package by.training.nc.dev3.beans.content;

import by.training.nc.dev3.beans.content.types.TypeIngredient;

import java.io.Serializable;

/**
 * Created by Win on 18.03.2017.
 */
public class AbstractIngredient implements Serializable {
    private TypeIngredient typeIngredient;
    private double cost;

    public AbstractIngredient(TypeIngredient typeIngredient, double cost) {
        this.typeIngredient = typeIngredient;
        this.cost = cost;
    }



    public double getCost() {
        return cost;
    }

    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    public void setTypeIngredient(TypeIngredient typeIngredient) {
        this.typeIngredient = typeIngredient;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    @Override
    public String toString() {
        return "name='" + typeIngredient + '\'' +
                ", cost=" + cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractIngredient that = (AbstractIngredient) o;

        if (Double.compare(that.cost, cost) != 0) return false;
        return typeIngredient.equals(that.typeIngredient);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = typeIngredient.hashCode();
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
