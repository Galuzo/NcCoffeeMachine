package by.training.nc.dev3.beans.machines;

import by.training.nc.dev3.beans.abstractions.AbstractBeverage;
import by.training.nc.dev3.beans.abstractions.AbstractIngredient;
import by.training.nc.dev3.beans.beverages.Latte;
import by.training.nc.dev3.beans.beverages.Tea;
import by.training.nc.dev3.beans.ingredients.Chocolate;
import by.training.nc.dev3.beans.ingredients.Milk;
import by.training.nc.dev3.enums.BeverageType;
import by.training.nc.dev3.enums.IngredientType;
import by.training.nc.dev3.fabrics.SimpleFactory;
import com.sun.org.apache.xalan.internal.xsltc.dom.SAXImpl;

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
        SimpleFactory simpleFactory=new SimpleFactory();
        AbstractBeverage tea=simpleFactory.createBeverage(BeverageType.TEA);
        AbstractBeverage latte=simpleFactory.createBeverage(BeverageType.LATTE);
        AbstractIngredient milk=simpleFactory.createIngredient(IngredientType.MILK);
        AbstractIngredient chocolate=simpleFactory.createIngredient(IngredientType.CHOCOLATE);
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
