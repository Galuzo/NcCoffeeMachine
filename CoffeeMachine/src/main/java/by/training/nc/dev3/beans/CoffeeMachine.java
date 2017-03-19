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


    public void addBeverage(AbstractBeverage beverage,int count)
    {
        if(beverages.containsKey(beverage))
        {
            int currentCount = beverages.get(beverage);
            currentCount+=count;
            beverages.put(beverage, currentCount);
        }
        else
            beverages.put(beverage,count);
    }

    public void addIngredient(AbstractIngredient ingredient,int count)
    {
        if(ingredients.containsKey(ingredient))
        {
            int currentCount = ingredients.get(ingredient);
            currentCount+=count;
            ingredients.put(ingredient, currentCount);
        }
        else
            ingredients.put(ingredient,count);
    }

    public void removeBeverage(AbstractBeverage beverage)
    {
        if(beverages.containsKey(beverage))
        {
            int currentCount=beverages.get(beverage);
            currentCount--;
            beverages.put(beverage, currentCount);
        }
    }
    public void removeIngredient(AbstractIngredient ingredient)
    {
        if(ingredients.containsKey(ingredient))
        {
            int currentCount=ingredients.get(ingredient);
            currentCount--;
            ingredients.put(ingredient, currentCount);
        }
    }

    public void showAssortiment()
    {
         System.out.println("***************Assortiment*****************");
        System.out.println("Beverages: ");
        for (Map.Entry<AbstractBeverage, Integer> entry : beverages.entrySet()) {
            System.out.println(" "+ entry.getKey() + " count= " + entry.getValue());
        }
        System.out.println("Ingredients: ");
        for (Map.Entry<AbstractIngredient, Integer> entry : ingredients.entrySet()) {
            System.out.println(" "+entry.getKey() + " count= " + entry.getValue());
        }

    }

    private boolean checkBeverageAvailability(AbstractBeverage beverage)
    {
        if(beverages.containsKey(beverage))
            return true;
        else
            return false;
    }

    private boolean checkIngredientAvailability(AbstractIngredient ingredient)
    {
        if(ingredients.containsKey(ingredient))
            return true;
        else
            return false;
    }

    public int checkBeverageCount(AbstractBeverage beverage) {
        if(checkBeverageAvailability(beverage))
            return beverages.get(beverage);
        else
            return 0;
        //Exepction

    }

    public int checkIngredientCount(AbstractIngredient ingredient) {
        if(checkIngredientAvailability(ingredient))
            return ingredients.get(ingredient);
        else
            return 0;
        //Exepction

    }


}
