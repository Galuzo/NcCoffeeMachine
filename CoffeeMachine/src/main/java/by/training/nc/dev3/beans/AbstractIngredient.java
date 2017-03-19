package by.training.nc.dev3.beans;

/**
 * Created by Win on 18.03.2017.
 */
public class AbstractIngredient {
    protected String description;
    protected double cost;

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractIngredient that = (AbstractIngredient) o;

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
}
