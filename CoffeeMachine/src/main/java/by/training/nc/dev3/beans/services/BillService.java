package by.training.nc.dev3.beans.services;

import by.training.nc.dev3.beans.abstractBeans.AbstractBeverage;
import by.training.nc.dev3.beans.abstractBeans.AbstractIngredient;
import by.training.nc.dev3.beans.bill.BillCalculator;
import by.training.nc.dev3.beans.persons.Client;

import java.util.List;
import java.util.Set;

/**
 * Created by Win on 21.03.2017.
 */
public class BillService {

    public void showResultBill(Client client)
    {
        System.out.println("***************Bill***********************");
        List<AbstractBeverage> beverages=client.getBill().getBeverages();
        Set<AbstractIngredient> ingredientsOfBeverage;
        if(!beverages.isEmpty())
            for (AbstractBeverage beverage : beverages) {
                System.out.print("beverage:"+beverage.getName());
                ingredientsOfBeverage=beverage.getListOfIngredients();
                for(AbstractIngredient ingredient:ingredientsOfBeverage)
                    System.out.print("+"+ingredient);
                System.out.println();
            }

        showResultCost(client);

    }

    private void showResultCost(Client client)
    {
        BillCalculator billCalculator=new BillCalculator();
        billCalculator.calculate(client.getBill());
        System.out.format("ResultCost=%.4f\n",billCalculator.getResultCost());
    }
}
