package by.training.nc.dev3.services;

import by.training.nc.dev3.beans.coffeeMachine.CoffeeMachine;
import by.training.nc.dev3.Instruments.Instruments;
import by.training.nc.dev3.beans.abstractBeans.AbstractBeverage;
import by.training.nc.dev3.beans.abstractBeans.AbstractIngredient;
import by.training.nc.dev3.beans.persons.Client;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Win on 21.03.2017.
 */
public class ClientService {
    private CoffeeMachine coffeeMachine;

    public  ClientService(CoffeeMachine coffeeMachine)
    {
        this.coffeeMachine=coffeeMachine;
    }

    public void addBeverageInBill(Client client,AbstractBeverage beverage) {
        Map<AbstractBeverage,Integer> beverages=coffeeMachine.getBeverages();
        List<AbstractBeverage> beveragesInBill=client.getBill().getBeverages();
        if(Instruments.checkCount(beverages,beverage)>0)
        {
            beveragesInBill.add(beverage);
            int currentCount=Instruments.decrementValue(beverages,beverage,1);
            beverages.put(beverage, currentCount);
        }
    }


    public void addIngredient(Client client,AbstractBeverage beverage, AbstractIngredient ingredient) {
        List<AbstractBeverage> beveragesInBill=client.getBill().getBeverages();
        Map<AbstractIngredient,Integer> allIngredients=coffeeMachine.getIngredients();
        Set<AbstractIngredient> currentIngredients=beverage.getListOfIngredients();
        if(beveragesInBill.contains(beverage))
            if(Instruments.checkCount(allIngredients,ingredient)>0)
            {
                currentIngredients.add(ingredient);
                int currentCount=Instruments.decrementValue(allIngredients,ingredient,1);
                allIngredients.put(ingredient, currentCount);
            }
    }


    public void removeBeverageFromBill(Client client,AbstractBeverage beverage) {
        List<AbstractBeverage> beverages=client.getBill().getBeverages();
        Map<AbstractIngredient,Integer> allIngredientsInMachine=coffeeMachine.getIngredients();
        Map<AbstractBeverage,Integer> allBeveragesInMachine=coffeeMachine.getBeverages();
        int value;
        if(beverages.contains(beverage))
            for(AbstractIngredient ingredient:beverage.getListOfIngredients())
            {
                value=Instruments.incrementValue(allIngredientsInMachine,ingredient,1);
                allIngredientsInMachine.put(ingredient,value);
            }
        Set<AbstractIngredient> ingredientSet=beverage.getListOfIngredients();
        ingredientSet.clear();
        beverages.remove(beverage);
        value=Instruments.incrementValue(allBeveragesInMachine,beverage,1);
        allBeveragesInMachine.put(beverage,value);
    }

    public void removeIngredientFromBill(Client client,AbstractBeverage beverage,AbstractIngredient ingredient) {
        List<AbstractBeverage> beveragesInBill=client.getBill().getBeverages();
        Map<AbstractIngredient,Integer> allIngredientsInMachine=coffeeMachine.getIngredients();
        int value;
        if(beveragesInBill.contains(beverage))
        {
            if(beverage.getListOfIngredients().contains(ingredient)) {
                beverage.getListOfIngredients().remove(ingredient);
            }
            else
                System.out.println("ingredient was not found in the beverage");
            value=Instruments.incrementValue(allIngredientsInMachine,ingredient,1);
            allIngredientsInMachine.put(ingredient,value);
        }
    }


}
