package by.training.nc.dev3.beans.content.types;

import by.training.nc.dev3.enums.BeverageType;

import java.io.Serializable;

/**
 * Created by Win on 09.04.2017.
 */
public class TypeBeverage implements Serializable {
    private BeverageType beverageType;

    public TypeBeverage(BeverageType beverageType) {
        this.beverageType = beverageType;
    }

    public BeverageType getBeverageType() {
        return beverageType;
    }

    public void setBeverageType(BeverageType beverageType) {
        this.beverageType = beverageType;
    }

    @Override
    public String toString() {
        return "Beverage:"+beverageType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeBeverage that = (TypeBeverage) o;

        return beverageType == that.beverageType;
    }

    @Override
    public int hashCode() {
        return beverageType.hashCode();
    }
}
