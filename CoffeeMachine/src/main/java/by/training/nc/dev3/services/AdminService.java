package by.training.nc.dev3.services;

import by.training.nc.dev3.beans.content.AbstractBeverage;
import by.training.nc.dev3.beans.content.AbstractIngredient;
import by.training.nc.dev3.beans.persons.Administrator;
import by.training.nc.dev3.enums.BeverageType;
import by.training.nc.dev3.enums.IngredientType;
import by.training.nc.dev3.fabrics.SimpleFactory;

import java.util.Map;

/**
 * Created by Win on 21.03.2017.
 */
public class AdminService {

    public void addBeverage(Administrator administrator,BeverageType beverageType, int count)
    {
        AbstractBeverage beverage;
        beverage=SimpleFactory.createBeverage(beverageType);
        Map<AbstractBeverage,Integer> beverages=administrator.getCoffeeMachine().getBeverages();
        if(beverages.containsKey(beverage))
        {
            int currentCount = beverages.get(beverage);
            if(currentCount<administrator.getCoffeeMachine().getLimitOfPlace())
            {
                int difference=administrator.getCoffeeMachine().getLimitOfPlace()-currentCount;
                if(count>difference)
                {
                    currentCount+=difference;
                    System.out.println("You added "+difference+" "+beverageType);

                }
                else
                {
                    currentCount+=count;
                    System.out.println("You added "+count+" "+beverageType);
                }
                beverages.put(beverage, currentCount);
            }
            else
            {
                System.out.println("The  limit was reached");
            }
        }
        else {
            beverages.put(beverage, count);
        }

    }
    public void addIngredient(Administrator administrator,IngredientType ingredientType,int count)
    {
        AbstractIngredient ingredient;
        ingredient=SimpleFactory.createIngredient(ingredientType);
        Map<AbstractIngredient,Integer> ingredients=administrator.getCoffeeMachine().getIngredients();
        if(ingredients.containsKey(ingredient))
        {
            int currentCount = ingredients.get(ingredient);
            if(currentCount<administrator.getCoffeeMachine().getLimitOfPlace())
            {
                int difference=administrator.getCoffeeMachine().getLimitOfPlace()-currentCount;
                if(count>difference)
                {
                    currentCount+=difference;
                    System.out.println("You  added "+difference+" "+ingredientType);

                }
                else
                {
                    currentCount+=count;
                    System.out.println("You added "+count+" "+ingredientType);
                }
                ingredients.put(ingredient, currentCount);
            }
            else
            {
                System.out.println("The limit was reached");
            }
        }
        else {
            ingredients.put(ingredient, count);
        }
    }


}
