package by.training.nc.dev3.beans.beverages;

import by.training.nc.dev3.beans.abstractions.AbstractBeverage;

/**
 * Created by Win on 19.03.2017.
 */
public class Tea extends AbstractBeverage {
    private int countOfSugar;
    public Tea() {
        name = "Tea";
        cost=1.2;
        countOfSugar=1;
    }

    public int getCountOfSugar() {
        return countOfSugar;
    }

    public void setCountOfSugar(int countOfSugar) {
        this.countOfSugar = countOfSugar;
    }

}
