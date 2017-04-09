package by.training.nc.dev3.beans.content.types;

import by.training.nc.dev3.enums.IngredientType;

import java.io.Serializable;

/**
 * Created by Win on 09.04.2017.
 */
public class TypeIngredient implements Serializable{
    private IngredientType ingredientType;

    public TypeIngredient(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    public IngredientType getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Override
    public String toString() {
        return "Ingredient:"+ingredientType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeIngredient that = (TypeIngredient) o;

        return ingredientType == that.ingredientType;
    }

    @Override
    public int hashCode() {
        return ingredientType.hashCode();
    }
}
