package by.training.nc.dev3.beans.persons;

import by.training.nc.dev3.beans.bill.Bill;

/**
 * Created by Win on 18.03.2017.
 */
public class Client {
    private Bill bill;


    public Client() {
        bill=new Bill();
    }



    public Bill getBill() {
        return bill;
    }
}
