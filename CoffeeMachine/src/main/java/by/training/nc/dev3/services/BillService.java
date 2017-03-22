package by.training.nc.dev3.services;

import by.training.nc.dev3.beans.abstractions.AbstractBeverage;
import by.training.nc.dev3.beans.persons.Client;
import by.training.nc.dev3.instruments.BeverageComparator;
import by.training.nc.dev3.interfaces.Calculateble;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Win on 21.03.2017.
 */
public class BillService  {

    public void showResultBill(Client client)
    {
        System.out.println("***************Bill***********************");
        ListIterator<AbstractBeverage> listIter = client.getBill().getBeverages().listIterator();
        while(listIter.hasNext()){

            System.out.println(listIter.next());
        }
        System.out.println("Current Date: "+client.getBill().getCalendar().getTime());
        showResultCost(client);

    }

    public void sortBill(Client client)
    {
        List<AbstractBeverage> beverages=client.getBill().getBeverages();
        BeverageComparator beverageComparator=new BeverageComparator();
        if(!beverages.isEmpty())
        {
           Collections.sort(beverages, beverageComparator);
        }
        System.out.println("!Bill was sorted");

    }




    private void showResultCost(Client client)
    {
        Calculateble billCalculator=new BillCalculator();
        billCalculator.calculate(client.getBill());
        System.out.format("ResultCost=%.4f\n",client.getBill().getGeneralCost());
    }
}
