package by.training.nc.dev3;

import by.training.nc.dev3.beans.beverages.Tea;
import by.training.nc.dev3.beans.ingredients.Chocolate;
import by.training.nc.dev3.beans.ingredients.Milk;
import by.training.nc.dev3.beans.outputs.Bill;
import by.training.nc.dev3.beans.persons.Administrator;
import by.training.nc.dev3.enums.BeverageType;
import by.training.nc.dev3.instruments.MenuInitialisation;
import by.training.nc.dev3.services.AdminService;
import by.training.nc.dev3.services.BillService;
import by.training.nc.dev3.services.ClientService;
import by.training.nc.dev3.beans.machines.CoffeeMachine;
import by.training.nc.dev3.beans.beverages.Latte;
import by.training.nc.dev3.beans.persons.Client;
import by.training.nc.dev3.services.CoffeeMachineService;

/**
 * Created by Win on 18.03.2017.
 */
public class CoffeeMachineRunner {
    public static void main(String[] args) {
        MenuInitialisation.showMenu();
    }
}
