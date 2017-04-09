package by.training.nc.dev3.fabrics;

import by.training.nc.dev3.beans.content.types.TypeBeverage;
import by.training.nc.dev3.beans.content.types.TypeIngredient;
import by.training.nc.dev3.beans.content.AbstractBeverage;
import by.training.nc.dev3.beans.content.AbstractIngredient;
import by.training.nc.dev3.enums.BeverageType;
import by.training.nc.dev3.enums.IngredientType;

/**
 * Created by Win on 19.03.2017.
 */
public class SimpleFactory {
    public static AbstractBeverage createBeverage(BeverageType beverageType)
    {
        AbstractBeverage beverage=null;
        switch (beverageType)
        {
            case LATTE:
                beverage=new AbstractBeverage(new TypeBeverage(BeverageType.LATTE),0.5);
                break;
            case TEA:
                beverage=new AbstractBeverage(new TypeBeverage(BeverageType.TEA),0.6);
                break;
        }
        return  beverage;
    }

    public static AbstractIngredient createIngredient(IngredientType ingredientType)
    {
        AbstractIngredient ingredient=null;
        switch (ingredientType)
        {
            case CHOCOLATE:
                ingredient=new AbstractIngredient(new TypeIngredient(IngredientType.CHOCOLATE), 0.2);
                break;
            case MILK:
                ingredient=new AbstractIngredient(new TypeIngredient(IngredientType.MILK),0.3);
                break;

        }
        return  ingredient;
    }
}


