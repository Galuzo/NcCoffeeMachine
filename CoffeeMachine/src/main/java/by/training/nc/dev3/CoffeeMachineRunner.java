package by.training.nc.dev3;

import by.training.nc.dev3.beans.CoffeeMachine;
import by.training.nc.dev3.beans.beverages.Latte;
import by.training.nc.dev3.beans.beverages.Tea;
import by.training.nc.dev3.beans.ingredients.Chocolate;
import by.training.nc.dev3.beans.ingredients.Milk;
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
        coffeeMachine.showAssortiment();
        Administrator administrator = new Administrator(coffeeMachine);
        administrator.addBeverage(BeverageType.LATTE);
        administrator.addIngredient(IngredientType.CHOCOLATE);
        coffeeMachine.showAssortiment();
        Tea tea=new Tea();
        Latte latte=new Latte();

        Chocolate chocolate=new Chocolate();
        Client client = new Client(coffeeMachine);
        client.buyBeverage(tea);
        client.buyBeverage(latte);
        client.addIngredient(latte,chocolate);
        client.removeBeverageFromBill(latte);
        client.addIngredient(tea,chocolate);
        client.showResultBill();

    }
}
