package by.training.nc.dev3.beans.bill;

import by.training.nc.dev3.beans.AbstractBeverage;
import by.training.nc.dev3.beans.AbstractIngredient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Win on 19.03.2017.
 */
public class Bill {
   private List<AbstractBeverage> beverages = new ArrayList<AbstractBeverage>();
   private List<AbstractIngredient> ingredients=new ArrayList<AbstractIngredient>();

    public void addBeverageInBill(AbstractBeverage beverage) {
        beverages.add(beverage);
    }

    public void addBIngredientInBill(AbstractIngredient ingredient) {
        ingredients.add(ingredient);
    }

    public boolean billContainBeverage(AbstractBeverage beverage) {
        if(beverages.contains(beverage))
            return true;
        else
            return false;
    }

    public boolean removeBeverageFromBill(AbstractBeverage beverage) {
        if (beverages.contains(beverage)) {
            beverages.remove(beverage);
            return true;
        }
        else
            return false;
    }
    public boolean removeIngredientFromBill(AbstractIngredient ingredient) {
        if (ingredients.contains(ingredient)) {
            ingredients.remove(ingredient);
            return true;
        }
        else
            return false;
    }


    public void showResultBill() {

        if(!beverages.isEmpty())
            for (AbstractBeverage beverage : beverages) {
                System.out.println(" "+beverage.getDescription()+" "+"cost:"+beverage.getCost());
            }
        if(!ingredients.isEmpty())
            for (AbstractIngredient ingredient : ingredients) {
                System.out.println(" "+ingredient.getDescription()+" "+"cost:"+ingredient.getCost());
            }
    }

    public List<AbstractBeverage> getBeverages() {
        return beverages;
    }

    public List<AbstractIngredient> getIngredients() {
        return ingredients;
    }
}
