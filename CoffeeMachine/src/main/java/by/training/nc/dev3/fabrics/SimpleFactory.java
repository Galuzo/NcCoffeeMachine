package by.training.nc.dev3.fabrics;

import by.training.nc.dev3.beans.abstractions.AbstractBeverage;
import by.training.nc.dev3.beans.abstractions.AbstractIngredient;
import by.training.nc.dev3.beans.beverages.Latte;
import by.training.nc.dev3.beans.beverages.Tea;
import by.training.nc.dev3.beans.ingredients.Chocolate;
import by.training.nc.dev3.beans.ingredients.Milk;
import by.training.nc.dev3.enums.BeverageType;
import by.training.nc.dev3.enums.IngredientType;

/**
 * Created by Win on 19.03.2017.
 */
public class SimpleFactory {
    public AbstractBeverage createBeverage(BeverageType beverageType)
    {
        AbstractBeverage beverage=null;
        switch (beverageType)
        {
            case LATTE:
                beverage=new Latte();
                break;
            case TEA:
                beverage=new Tea();
                break;
        }
        return  beverage;
    }

    public AbstractIngredient createIngredient(IngredientType ingredientType)
    {
        AbstractIngredient ingredient=null;
        switch (ingredientType)
        {
            case CHOCOLATE:
                ingredient=new Chocolate();
                break;
            case MILK:
                ingredient=new Milk();
                break;

        }
        return  ingredient;
    }
}


