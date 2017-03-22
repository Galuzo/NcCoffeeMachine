package by.training.nc.dev3.beans.persons;

import by.training.nc.dev3.beans.coffeeMachine.CoffeeMachine;
import by.training.nc.dev3.fabrics.SimpleFactory;

/**
 * Created by Win on 18.03.2017.
 */
public class Administrator {
    CoffeeMachine coffeeMachine;


    public Administrator(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public CoffeeMachine getCoffeeMachine() {
        return coffeeMachine;
    }


}
