package by.training.nc.dev3.services;

import by.training.nc.dev3.beans.abstractions.AbstractBeverage;
import by.training.nc.dev3.beans.abstractions.AbstractIngredient;
import by.training.nc.dev3.beans.persons.Client;
import by.training.nc.dev3.interfaces.Calculateble;

import java.util.List;
import java.util.Set;

/**
 * Created by Win on 21.03.2017.
 */
public class BillService  {

    public void showResultBill(Client client)
    {
        System.out.println("***************Bill***********************");
        List<AbstractBeverage> beverages=client.getBill().getBeverages();
        Set<AbstractIngredient> ingredientsOfBeverage;
        if(!beverages.isEmpty())
            for (AbstractBeverage beverage : beverages) {
                System.out.println(beverage);
            }
        showResultCost(client);

    }

    private void showResultCost(Client client)
    {
        Calculateble billCalculator=new BillCalculator();
        double billValue=billCalculator.calculate(client.getBill());
        System.out.format("ResultCost=%.4f\n",billValue);
    }
}
