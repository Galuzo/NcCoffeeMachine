package by.training.nc.dev3.beans;

import by.training.nc.dev3.beans.abstractBeans.AbstractBeverage;
import by.training.nc.dev3.beans.abstractBeans.AbstractIngredient;
import by.training.nc.dev3.beans.beverages.Latte;
import by.training.nc.dev3.beans.beverages.Tea;
import by.training.nc.dev3.beans.ingredients.Chocolate;
import by.training.nc.dev3.beans.ingredients.Milk;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Win on 18.03.2017.
 */
public class CoffeeMachine {
   private Map<AbstractBeverage, Integer> beverages = new HashMap<AbstractBeverage, Integer>();
   private Map<AbstractIngredient, Integer> ingredients = new HashMap<AbstractIngredient, Integer>();

    public CoffeeMachine()
    {
        Tea tea=new Tea();
        Latte latte=new Latte();
        Milk milk=new Milk();
        Chocolate chocolate=new Chocolate();
        ingredients.put(milk,5);
        ingredients.put(chocolate, 5);
        beverages.put(latte, 5);
        beverages.put(tea,5);
    }

    public Map<AbstractIngredient, Integer> getIngredients() {
        return ingredients;
    }
    public Map<AbstractBeverage, Integer> getBeverages() {
        return beverages;
    }




}
