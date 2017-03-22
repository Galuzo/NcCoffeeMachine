package by.training.nc.dev3.beans.persons;

import by.training.nc.dev3.beans.outputs.Bill;

/**
 * Created by Win on 18.03.2017.
 */
public class Client {
    private Bill bill;
    public static int numberOfEntities = 0;


    public Client() {

        bill=new Bill();
        numberOfEntities++;
    }



    public Bill getBill() {
        return bill;
    }
}
