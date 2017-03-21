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

    public CoffeeMachine getCoffeeMachine() {
        return coffeeMachine;
    }

    public Bill getBill() {
        return bill;
    }
}
