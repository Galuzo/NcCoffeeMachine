package by.training.nc.dev3;

import by.training.nc.dev3.beans.CoffeeMachine;
import by.training.nc.dev3.beans.beverages.Latte;
import by.training.nc.dev3.beans.ingredients.Chocolate;
import by.training.nc.dev3.beans.persons.Administrator;
import by.training.nc.dev3.beans.persons.Client;
import by.training.nc.dev3.enums.BeverageType;
import by.training.nc.dev3.enums.IngredientType;

/**
 * Created by Win on 18.03.2017.
 */
public class CoffeeMachineRunner {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine=new CoffeeMachine();
        Administrator administrator = new Administrator(coffeeMachine);
        coffeeMachine.showAssortiment();
        administrator.addBeverage(BeverageType.TEA);
        administrator.addBeverage(BeverageType.TEA);
        administrator.addBeverage(BeverageType.LATTE);
        administrator.addIngredient(IngredientType.CHOCOLATE);
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
