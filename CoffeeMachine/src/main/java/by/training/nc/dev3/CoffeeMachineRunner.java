package by.training.nc.dev3;

import by.training.nc.dev3.beans.beverages.Tea;
import by.training.nc.dev3.beans.ingredients.Chocolate;
import by.training.nc.dev3.beans.ingredients.Milk;
import by.training.nc.dev3.beans.persons.Administrator;
import by.training.nc.dev3.enums.BeverageType;
import by.training.nc.dev3.services.AdminService;
import by.training.nc.dev3.services.BillService;
import by.training.nc.dev3.services.ClientService;
import by.training.nc.dev3.beans.coffeeMachine.CoffeeMachine;
import by.training.nc.dev3.fabrics.SimpleFactory;
import by.training.nc.dev3.beans.beverages.Latte;
import by.training.nc.dev3.beans.persons.Client;
import by.training.nc.dev3.services.CoffeeMachineService;

/**
 * Created by Win on 18.03.2017.
 */
public class CoffeeMachineRunner {
    public static void main(String[] args) {
        CoffeeMachineService coffeeMachineService=new CoffeeMachineService();
        CoffeeMachine coffeeMachine=new CoffeeMachine();

       ClientService clientService=new ClientService(coffeeMachine);
       Latte latte=new Latte();
        Tea tea=new Tea();

        Administrator administrator = new Administrator(coffeeMachine);
        AdminService adminService = new AdminService();
        adminService.addBeverage(administrator, BeverageType.LATTE,5);
        coffeeMachineService.showAssortiment(coffeeMachine);
        Milk milk = new Milk();
        Chocolate chocolate=new Chocolate();
        Client client = new Client();
        clientService.addBeverageInBill(client,latte);
        clientService.addBeverageInBill(client,tea);
        clientService.addIngredient(client,tea,chocolate);
        clientService.addIngredient(client,latte,chocolate);
        BillService billService = new BillService();
        clientService.addIngredient(client,tea,milk);
        billService.showResultBill(client);
        coffeeMachineService.showAssortiment(coffeeMachine);


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
