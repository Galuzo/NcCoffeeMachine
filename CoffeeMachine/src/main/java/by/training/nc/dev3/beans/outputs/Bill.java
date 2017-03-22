package by.training.nc.dev3.beans.outputs;

import by.training.nc.dev3.beans.abstractions.AbstractBeverage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Win on 19.03.2017.
 */
public class Bill {
   private List<AbstractBeverage> beverages = new ArrayList<AbstractBeverage>();
   private double generalCost;
   private GregorianCalendar calendar=new GregorianCalendar();

    public GregorianCalendar getCalendar() {
        return calendar;
    }

    public double getGeneralCost() {
        return generalCost;
    }

    public void setGeneralCost(double generalCost) {
        this.generalCost = generalCost;
    }

    public List<AbstractBeverage> getBeverages() {
        return beverages;
    }

}
