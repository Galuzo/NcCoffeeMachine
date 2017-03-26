package by.training.nc.dev3.services;

import by.training.nc.dev3.beans.machines.CoffeeMachine;
import by.training.nc.dev3.enums.BeverageType;
import by.training.nc.dev3.enums.IngredientType;
import by.training.nc.dev3.exceptions.IncorrectValue;
import by.training.nc.dev3.exceptions.NotFoundException;
import by.training.nc.dev3.fabrics.SimpleFactory;
import by.training.nc.dev3.instruments.Instruments;
import by.training.nc.dev3.beans.abstractions.AbstractBeverage;
import by.training.nc.dev3.beans.abstractions.AbstractIngredient;
import by.training.nc.dev3.beans.persons.Client;

import java.util.*;

/**
 * Created by Win on 21.03.2017.
 */
public class ClientService {
    private CoffeeMachine coffeeMachine;

    public  ClientService(CoffeeMachine coffeeMachine)
    {
        this.coffeeMachine=coffeeMachine;
    }

    public void addBeverageInBill(Client client, BeverageType beverageType) {
        SimpleFactory simpleFactory=new SimpleFactory();
        AbstractBeverage beverage=simpleFactory.createBeverage(beverageType);
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


   public boolean addIngredient(Client client, int numberOfBeverage, IngredientType ingredientType) {
        List<AbstractBeverage> beveragesInBill=client.getBill().getBeverages();
        Map<AbstractIngredient,Integer> allIngredients=coffeeMachine.getIngredients();
        AbstractBeverage beverage=getBeverageForEdit(client,--numberOfBeverage);
        SimpleFactory simpleFactory=new SimpleFactory();
        Set<AbstractIngredient> currentIngredients=beverage.getListOfIngredients();
        AbstractIngredient ingredient = simpleFactory.createIngredient(ingredientType);
        if(beveragesInBill.contains(beverage)) {
            try {
                if(!beverage.getListOfIngredients().contains(ingredient)) {
                    Instruments.checkCount(allIngredients, ingredient);
                    currentIngredients.add(ingredient);
                    int currentCount = Instruments.decrementValue(allIngredients, ingredient, 1);
                    allIngredients.put(ingredient, currentCount);
                    return true;
                }
                else {
                    System.out.println(ingredientType + " is already consisted");
                    return false;
                }


            } catch (NotFoundException e) {
                System.out.println("ERROR:the ingredient was not added ," + e.getMessage() + e.getElement() + ")");
            } catch (IncorrectValue incorrectValue) {
                System.out.println("ERROR:the ingredient was not added,it had  ended(" + incorrectValue.getElement() + ")");
            }
        }
       else {
            System.out.println("ERROR:The beverage was not found in outputs");
        }
        return false;
   }


    public void removeBeverageFromBill(Client client,int numberOfBeverage) {
        List<AbstractBeverage> beverages=client.getBill().getBeverages();
        Map<AbstractIngredient,Integer> allIngredientsInMachine=coffeeMachine.getIngredients();
        Map<AbstractBeverage,Integer> allBeveragesInMachine=coffeeMachine.getBeverages();
        AbstractBeverage beverage=getBeverageForEdit(client,--numberOfBeverage);
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
        else {
            System.out.println("ERROR:The beverage was not found in outputs");
        }
    }

    public void removeIngredientFromBill(Client client,int numberOfBeverage,int numberOfIngredient) {
        List<AbstractBeverage> beveragesInBill=client.getBill().getBeverages();
        AbstractBeverage beverage=getBeverageForEdit(client,numberOfBeverage);
        AbstractIngredient ingredient = getIngredientForEdit(client, numberOfBeverage, --numberOfIngredient);
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
            else {
                System.out.println("ERROR:ingredient was not found in the beverage:" + beverage);
            }
        }
        else
            System.out.println("ERROR:The beverage was not found in outputs");
    }

    public AbstractBeverage getBeverageForEdit(Client client,int number)
    {
        AbstractBeverage beverage=client.getBill().getBeverages().get(number);
        return beverage;
    }

    public AbstractIngredient getIngredientForEdit(Client client,int numberOfBeverage,int numberOfIngredient)
    {
        List<AbstractIngredient> listOfIngredients = new ArrayList<AbstractIngredient>(client.getBill().getBeverages().get(numberOfBeverage).getListOfIngredients());
        AbstractIngredient ingredient=listOfIngredients.get(numberOfIngredient);
        return ingredient;
    }

    public CoffeeMachine getCoffeeMachine() {
        return coffeeMachine;
    }

    public void setCoffeeMachine(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }
}
