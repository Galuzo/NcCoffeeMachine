package by.training.nc.dev3.beans.persons;

import by.training.nc.dev3.beans.coffeeMachine.CoffeeMachine;
import by.training.nc.dev3.fabrics.SimpleFactory;

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
