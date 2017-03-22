package by.training.nc.dev3.services;

import by.training.nc.dev3.beans.machines.CoffeeMachine;
import by.training.nc.dev3.exceptions.IncorrectValue;
import by.training.nc.dev3.exceptions.NotFoundException;
import by.training.nc.dev3.instruments.Instruments;
import by.training.nc.dev3.beans.abstractions.AbstractBeverage;
import by.training.nc.dev3.beans.abstractions.AbstractIngredient;
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
        try {
            Instruments.checkCount(beverages,beverage);
            beveragesInBill.add(beverage);
                int currentCount=Instruments.decrementValue(beverages,beverage,1);
                beverages.put(beverage, currentCount);

        } catch (NotFoundException e) {
            System.out.println("ERROR:the beverage was not added ,"+e.getMessage()+e.getElement()+")");
        } catch (IncorrectValue incorrectValue) {
            System.out.println("ERROR:the beverage was not added,it had  ended("+incorrectValue.getElement()+")");
        }
    }


   public void addIngredient(Client client,AbstractBeverage beverage, AbstractIngredient ingredient) {
        List<AbstractBeverage> beveragesInBill=client.getBill().getBeverages();
        Map<AbstractIngredient,Integer> allIngredients=coffeeMachine.getIngredients();
        Set<AbstractIngredient> currentIngredients=beverage.getListOfIngredients();
        if(beveragesInBill.contains(beverage))
            try {
                Instruments.checkCount(allIngredients,ingredient);
                currentIngredients.add(ingredient);
                int currentCount=Instruments.decrementValue(allIngredients,ingredient,1);
                allIngredients.put(ingredient, currentCount);

            } catch (NotFoundException e) {
                System.out.println("ERROR:the ingredient was not added ,"+e.getMessage()+e.getElement()+")");
            } catch (IncorrectValue incorrectValue) {
                System.out.println("ERROR:the ingredient was not added,it had  ended("+incorrectValue.getElement()+")");
            }
       else
            System.out.println("ERROR:The beverage was not found in outputs");
   }


    public void removeBeverageFromBill(Client client,AbstractBeverage beverage) {
        List<AbstractBeverage> beverages=client.getBill().getBeverages();
        Map<AbstractIngredient,Integer> allIngredientsInMachine=coffeeMachine.getIngredients();
        Map<AbstractBeverage,Integer> allBeveragesInMachine=coffeeMachine.getBeverages();
        int value=0;
        if(beverages.contains(beverage)) {
            for (AbstractIngredient ingredient : beverage.getListOfIngredients()) {
                try {
                    value = Instruments.incrementValue(allIngredientsInMachine, ingredient, 1);
                } catch (NotFoundException e) {
                    System.out.println("ERROR:the ingredient was not removed from list Of ingredients ,"+e.getMessage()+e.getElement()+")");
                } catch (IncorrectValue incorrectValue) {
                    System.out.println("ERROR:the ingredient was not removed,the value is incorrect("+incorrectValue.getElement()+")");
                }
                allIngredientsInMachine.put(ingredient, value);
            }
            Set<AbstractIngredient> ingredientSet = beverage.getListOfIngredients();
            ingredientSet.clear();
            beverages.remove(beverage);
            try {
                value = Instruments.incrementValue(allBeveragesInMachine, beverage, 1);
            } catch (NotFoundException e) {
                System.out.println("ERROR:the beverage was not removed ,"+e.getMessage()+e.getElement()+")");
            } catch (IncorrectValue incorrectValue) {
                System.out.println("ERROR:the beverage was not removed,the value is incorrect("+incorrectValue.getElement()+")");
            }
            allBeveragesInMachine.put(beverage, value);
        }
        else
            System.out.println("ERROR:The beverage was not found in outputs");
    }

    public void removeIngredientFromBill(Client client,AbstractBeverage beverage,AbstractIngredient ingredient) {
        List<AbstractBeverage> beveragesInBill=client.getBill().getBeverages();
        Map<AbstractIngredient,Integer> allIngredientsInMachine=coffeeMachine.getIngredients();
        int value=0;
        if(beveragesInBill.contains(beverage))
        {
            if(beverage.getListOfIngredients().contains(ingredient)) {
                beverage.getListOfIngredients().remove(ingredient);
                try {
                    value = Instruments.incrementValue(allIngredientsInMachine, ingredient, 1);
                } catch (NotFoundException e) {
                    System.out.println("ERROR:the ingredient was not removed ," + e.getMessage() + e.getElement() + ")");
                } catch (IncorrectValue incorrectValue) {
                    System.out.println("ERROR:the beverage was not removed,the value is incorrect(" + incorrectValue.getElement() + ")");
                }
                allIngredientsInMachine.put(ingredient, value);
            }
            else
                System.out.println("ERROR:ingredient was not found in the beverage");
        }
        else
            System.out.println("ERROR:The beverage was not found in outputs");
    }

    public CoffeeMachine getCoffeeMachine() {
        return coffeeMachine;
    }

    public void setCoffeeMachine(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }
}
