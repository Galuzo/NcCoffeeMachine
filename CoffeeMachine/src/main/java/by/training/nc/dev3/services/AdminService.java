package by.training.nc.dev3.services;

import by.training.nc.dev3.beans.abstractions.AbstractBeverage;
import by.training.nc.dev3.beans.abstractions.AbstractIngredient;
import by.training.nc.dev3.beans.persons.Administrator;
import by.training.nc.dev3.enums.BeverageType;
import by.training.nc.dev3.enums.IngredientType;
import by.training.nc.dev3.fabrics.SimpleFactory;

import java.util.Map;

/**
 * Created by Win on 21.03.2017.
 */
public class AdminService {
    SimpleFactory simpleFactory;
    public  AdminService()
    {
       simpleFactory=new SimpleFactory();
    }
    public void addBeverage(Administrator administrator,BeverageType beverageType, int count)
    {
        AbstractBeverage beverage;
        beverage=simpleFactory.createBeverage(beverageType);
        Map<AbstractBeverage,Integer> beverages=administrator.getCoffeeMachine().getBeverages();
        if(beverages.containsKey(beverage))
        {
            int currentCount = beverages.get(beverage);
            currentCount+=count;
            beverages.put(beverage, currentCount);
        }
        else {
            beverages.put(beverage, count);
        }

    }
    public void addIngredient(Administrator administrator,IngredientType ingredientType,int count)
    {
        AbstractIngredient ingredient;
        ingredient=simpleFactory.createIngredient(ingredientType);
        Map<AbstractIngredient,Integer> ingredients=administrator.getCoffeeMachine().getIngredients();
        if(ingredients.containsKey(ingredient))
        {
            int currentCount = ingredients.get(ingredient);
            currentCount+=count;
            ingredients.put(ingredient, currentCount);
        }
        else {
            ingredients.put(ingredient, count);
        }
    }
}
