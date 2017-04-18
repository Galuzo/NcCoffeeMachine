package by.training.nc.dev3.beans;

import by.training.nc.dev3.beans.Entity;

import java.util.Date;

/**
 * Created by Win on 19.03.2017.
 */
public class Bill extends Entity{
    private long idUsers;
    private double generalCost;
    private Date date;

    public Bill(){}
    public Bill(int id, long idUsers, double generalCost,  Date date) {
        super(id);
        this.idUsers = idUsers;
        this.generalCost = generalCost;
        this.date = date;
    }

    public long getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(long idUsers) {
        this.idUsers = idUsers;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getGeneralCost() {
        return generalCost;
    }
    public void setGeneralCost(double generalCost) {
        this.generalCost = generalCost;
    }


}
