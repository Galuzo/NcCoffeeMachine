package by.training.nc.dev3.beans.persons;

import by.training.nc.dev3.beans.*;
import by.training.nc.dev3.beans.bill.Bill;
import by.training.nc.dev3.beans.bill.BillCalculator;

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

    public void buyBeverage(AbstractBeverage beverage) {
        if(coffeeMachine.checkBeverageCount(beverage)>0) {
            bill.addBeverageInBill(beverage);
            coffeeMachine.removeBeverage(beverage);
        }
    }


    public void addIngredient(AbstractBeverage beverage, AbstractIngredient ingredient) {
        if(bill.billContainBeverage(beverage))
            if(coffeeMachine.checkIngredientCount(ingredient)>0) {
                bill.addBIngredientInBill(ingredient);
                coffeeMachine.removeIngredient(ingredient);
            }
        //exeption
    }


    public void removeBeverageFromBill(AbstractBeverage beverage) {
        if(bill.removeBeverageFromBill(beverage))
            coffeeMachine.addBeverage(beverage,1);
    }

    public void removeIngredientFromBill(AbstractIngredient ingredient) {
        if(bill.removeIngredientFromBill(ingredient))
            coffeeMachine.addIngredient(ingredient,1);
    }

    public void showResultBill()
    {
        System.out.println("***************Bill***********************");
        bill.showResultBill();

    }

    public void showResultCost()
    {
        BillCalculator billCalculator=new BillCalculator();
        billCalculator.calculate(bill);
        System.out.format("ResultCost=%.4f",billCalculator.getResultCost());
    }
}
