package by.training.nc.dev3.beans.persons;

import by.training.nc.dev3.beans.*;
import by.training.nc.dev3.beans.abstractBeans.AbstractBeverage;
import by.training.nc.dev3.beans.abstractBeans.AbstractIngredient;
import by.training.nc.dev3.beans.bill.Bill;
import by.training.nc.dev3.beans.bill.BillCalculator;
import by.training.nc.dev3.enums.IngredientType;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Win on 18.03.2017.
 */
public class Client {
    private Bill bill;
    private CoffeeMachine coffeeMachine;

    public Client( CoffeeMachine coffeeMachine) {
        bill=new Bill();
        this.coffeeMachine = coffeeMachine;
    }

    public void addBeverageInBill(AbstractBeverage beverage) {
        Map<AbstractBeverage,Integer> beverages=coffeeMachine.getBeverages();
        List<AbstractBeverage>  beveragesInBill=bill.getBeverages();
        if(Instruments.checkCount(beverages,beverage)>0)
        {
            beveragesInBill.add(beverage);
            int currentCount=Instruments.decrementValue(beverages,beverage,1);
            beverages.put(beverage, currentCount);
        }
    }


    public void addIngredient(AbstractBeverage beverage, AbstractIngredient ingredient) {
        List<AbstractBeverage> beveragesInBill=bill.getBeverages();
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


    public void removeBeverageFromBill(AbstractBeverage beverage) {
        List<AbstractBeverage> beverages=bill.getBeverages();
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

    public void removeIngredientFromBill(AbstractBeverage beverage,AbstractIngredient ingredient) {
       List<AbstractBeverage> beveragesInBill=bill.getBeverages();
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

    public void showResultBill()
    {
        System.out.println("***************Bill***********************");
        List<AbstractBeverage> beverages=bill.getBeverages();
        Set<AbstractIngredient> ingredientsOfBeverage;
        if(!beverages.isEmpty())
            for (AbstractBeverage beverage : beverages) {
                System.out.print("beverage:"+beverage.getName());
                ingredientsOfBeverage=beverage.getListOfIngredients();
                for(AbstractIngredient ingredient:ingredientsOfBeverage)
                    System.out.print("+"+ingredient);
                System.out.println();
            }

        showResultCost();

    }

    private void showResultCost()
    {
        BillCalculator billCalculator=new BillCalculator();
        billCalculator.calculate(bill);
        System.out.format("ResultCost=%.4f\n",billCalculator.getResultCost());
    }
}
