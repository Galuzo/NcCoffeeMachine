package by.training.nc.dev3.beans.persons;

import by.training.nc.dev3.beans.AbstractBeverage;
import by.training.nc.dev3.beans.AbstractIngredient;
import by.training.nc.dev3.beans.CoffeeMachine;
import by.training.nc.dev3.beans.SimpleFactory;
import by.training.nc.dev3.enums.BeverageType;
import by.training.nc.dev3.enums.IngredientType;

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

    public void addBeverage(BeverageType beverageType)
    {
        AbstractBeverage beverage;
        beverage=simpleFactory.createBeverage(beverageType);
        coffeeMachine.addBeverage(beverage,1);
    }
    public void addIngredient(IngredientType ingredientType)
    {
        AbstractIngredient ingredient;
        ingredient=simpleFactory.createIngredient(ingredientType);
        coffeeMachine.addIngredient(ingredient,1);
    }

}
