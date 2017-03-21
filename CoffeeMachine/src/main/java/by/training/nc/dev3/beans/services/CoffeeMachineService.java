package by.training.nc.dev3.beans.services;

import by.training.nc.dev3.beans.CoffeeMachine;
import by.training.nc.dev3.beans.abstractBeans.AbstractBeverage;
import by.training.nc.dev3.beans.abstractBeans.AbstractIngredient;

import java.util.Map;

/**
 * Created by Win on 21.03.2017.
 */
public class CoffeeMachineService {

    public void showAssortiment(CoffeeMachine coffeeMachine)
    {
        System.out.println("***************Assortiment*****************");
        System.out.println("Beverages: ");
        for (Map.Entry<AbstractBeverage, Integer> entry : coffeeMachine.getBeverages().entrySet()) {
            System.out.println(" "+ entry.getKey() + " count= " + entry.getValue());
        }
        System.out.println("Ingredients: ");
        for (Map.Entry<AbstractIngredient, Integer> entry : coffeeMachine.getIngredients().entrySet()) {
            System.out.println(" "+entry.getKey() + " count= " + entry.getValue());
        }

    }
}
