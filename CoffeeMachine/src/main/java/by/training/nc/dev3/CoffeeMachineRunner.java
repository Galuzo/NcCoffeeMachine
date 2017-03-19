package by.training.nc.dev3;

import by.training.nc.dev3.beans.CoffeeMachine;
import by.training.nc.dev3.beans.beverages.Latte;
import by.training.nc.dev3.beans.ingredients.Chocolate;
import by.training.nc.dev3.beans.persons.Client;

/**
 * Created by Win on 18.03.2017.
 */
public class CoffeeMachineRunner {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine=new CoffeeMachine();
        coffeeMachine.showAssortiment();
        Client client = new Client(coffeeMachine);
        Latte latte = new Latte();
        Chocolate chocolate=new Chocolate();
        client.buyBeverage(latte);
        client.buyBeverage(latte);
        client.addIngredient(latte,chocolate);
        coffeeMachine.showAssortiment();
        client.showResultBill();

        client.showResultBill();
        client.showResultCost();
    }
}
