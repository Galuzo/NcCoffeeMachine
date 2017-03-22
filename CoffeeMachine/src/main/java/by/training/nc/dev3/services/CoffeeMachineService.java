package by.training.nc.dev3.services;

import by.training.nc.dev3.beans.machines.CoffeeMachine;
import by.training.nc.dev3.beans.abstractions.AbstractBeverage;
import by.training.nc.dev3.beans.abstractions.AbstractIngredient;
import by.training.nc.dev3.beans.persons.Client;

import java.util.Collections;
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
            System.out.println(" "+ entry.getKey().getName() + " count=" + entry.getValue()+" ,cost="+entry.getKey().getCost());
        }
        System.out.println("Ingredients: ");
        for (Map.Entry<AbstractIngredient, Integer> entry : coffeeMachine.getIngredients().entrySet()) {
            System.out.println(" "+entry.getKey().getName() + " count=" + entry.getValue()+",cost="+entry.getKey().getCost());
        }
    }

    public void compareBills(Client client1,Client client2)
    {
        if (client1.compareTo(client2) > 0) {
            System.out.println("Bill of first client is more  ");
        } else {
            System.out.println("Bill of second client is more  ");
        }
    }


}
