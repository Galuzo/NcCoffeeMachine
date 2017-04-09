package by.training.nc.dev3.beans.machines;

import by.training.nc.dev3.beans.content.AbstractBeverage;
import by.training.nc.dev3.beans.content.AbstractIngredient;
import by.training.nc.dev3.enums.BeverageType;
import by.training.nc.dev3.enums.IngredientType;
import by.training.nc.dev3.fabrics.SimpleFactory;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Win on 18.03.2017.
 */
public class CoffeeMachine implements Serializable {
   private Map<AbstractBeverage, Integer> beverages = new HashMap<AbstractBeverage, Integer>();
   private Map<AbstractIngredient, Integer> ingredients = new HashMap<AbstractIngredient, Integer>();
   private int limitOfPlace=100;

    public CoffeeMachine()
    {

        AbstractBeverage latte=SimpleFactory.createBeverage(BeverageType.LATTE);
        AbstractBeverage tea = SimpleFactory.createBeverage(BeverageType.TEA);
        AbstractIngredient milk = SimpleFactory.createIngredient(IngredientType.MILK);
        AbstractIngredient chocolate = SimpleFactory.createIngredient(IngredientType.CHOCOLATE);
        ingredients.put(milk,5);
        ingredients.put(chocolate, 5);
        beverages.put(latte, 10);
        beverages.put(tea,10);
    }

    public Map<AbstractIngredient, Integer> getIngredients() {
        return ingredients;
    }
    public Map<AbstractBeverage, Integer> getBeverages() {
        return beverages;
    }

    public int getLimitOfPlace() {
        return limitOfPlace;
    }

    public void setLimitOfPlace(int limitOfPlace) {
        this.limitOfPlace = limitOfPlace;
    }
}
