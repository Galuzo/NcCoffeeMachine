package by.training.nc.dev3.beans.persons;

import by.training.nc.dev3.beans.outputs.Bill;

/**
 * Created by Win on 18.03.2017.
 */
public class Client implements Comparable<Client> {
    private Bill bill;
    public static int numberOfEntities = 0;


    public Client() {
        bill=new Bill();
        numberOfEntities++;
    }

    public int compareTo(Client o) {
        if(this.getBill().getGeneralCost()>o.getBill().getGeneralCost())
        {
            return 1;
        }
        else if(this.getBill().getGeneralCost()>o.getBill().getGeneralCost())
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }

    public Bill getBill() {
        return bill;
    }
}
