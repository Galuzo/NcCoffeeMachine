package by.training.nc.dev3.beans.persons;

import by.training.nc.dev3.beans.abstractBeans.AbstractBeverage;
import by.training.nc.dev3.beans.abstractBeans.AbstractIngredient;
import by.training.nc.dev3.beans.CoffeeMachine;
import by.training.nc.dev3.beans.SimpleFactory;
import by.training.nc.dev3.enums.BeverageType;
import by.training.nc.dev3.enums.IngredientType;

import java.util.Map;

/**
 * Created by Win on 18.03.2017.
 */
public class Administrator {
    CoffeeMachine coffeeMachine;
    SimpleFactory simpleFactory;

    public Administrator(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
        simpleFactory=new SimpleFactory();
    }

    public CoffeeMachine getCoffeeMachine() {
        return coffeeMachine;
    }

    public SimpleFactory getSimpleFactory() {
        return simpleFactory;
    }
}
