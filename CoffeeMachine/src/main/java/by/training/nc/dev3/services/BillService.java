package by.training.nc.dev3.services;

import by.training.nc.dev3.beans.content.AbstractBeverage;
import by.training.nc.dev3.beans.persons.Client;
import by.training.nc.dev3.instruments.BeverageComparator;
import by.training.nc.dev3.instruments.FileWorker;
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
        sortBill(client);
        int index=1;

        ListIterator<AbstractBeverage> listIter = client.getBill().getBeverages().listIterator();
        if(listIter.hasNext()) {
            while (listIter.hasNext()) {

                System.out.println(index + ". " + listIter.next());
                index++;
            }
            System.out.println("Current Date: " + client.getBill().getCalendar().getTime());
            showResultCost(client);
        }
        else {
            System.out.println("\tBill is empty");
            FileWorker.writeLogger("Bill is empty");
        }
    }

    public void sortBill(Client client)
    {
        List<AbstractBeverage> beverages=client.getBill().getBeverages();
        BeverageComparator beverageComparator=new BeverageComparator();
        if(!beverages.isEmpty())
        {
           Collections.sort(beverages, beverageComparator);
        }


    }




    private void showResultCost(Client client)
    {
        Calculateble billCalculator=new BillCalculator();
        billCalculator.calculate(client.getBill());
        System.out.format("ResultCost=%.4f\n",client.getBill().getGeneralCost());
    }
}
