package by.training.nc.dev3;

import by.training.nc.dev3.beans.CoffeeMachine;
import by.training.nc.dev3.beans.SimpleFactory;
import by.training.nc.dev3.beans.abstractBeans.AbstractBeverage;
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
        SimpleFactory simpleFactory=new SimpleFactory();
        CoffeeMachine coffeeMachine=new CoffeeMachine();
        Client client = new Client(coffeeMachine);
        Chocolate chocolate=new Chocolate();
        Latte latte=new Latte();
        Tea tea=new Tea();
        coffeeMachine.showAssortiment();
        client.addBeverageInBill(latte);
        client.addBeverageInBill(tea);
        client.addIngredient(tea,chocolate);
        client.removeIngredientFromBill(tea,chocolate);
        client.showResultBill();
        coffeeMachine.showAssortiment();
        /*CoffeeMachine coffeeMachine=new CoffeeMachine();
        coffeeMachine.showAssortiment();
        Administrator administrator = new Administrator(coffeeMachine);
        administrator.addBeverage(BeverageType.LATTE,2);
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
        client.showResultBill();*/

    }
}
