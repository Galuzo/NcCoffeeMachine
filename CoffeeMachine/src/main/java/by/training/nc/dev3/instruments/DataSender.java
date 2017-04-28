package by.training.nc.dev3.instruments;

import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.exceptions.DaoException;
import by.training.nc.dev3.services.BillService;
import by.training.nc.dev3.services.CoffeeMachineService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Win on 23.04.2017.
 */
public class DataSender {
    public static void sendMainData(HttpServletRequest request,User user)
    {
        CoffeeMachineService coffeeMachineService = new CoffeeMachineService();
        BillService billService = new BillService();
        try {
            request.setAttribute("billMap",billService.showResultBill(user));
        } catch (DaoException e) {
            request.setAttribute("ingredientError", e.getMessage());
        }
        request.setAttribute("beverages",coffeeMachineService.getBeveragesInMachine());
        request.setAttribute("ingredients",coffeeMachineService.getIngredientsInMachine());
        request.setAttribute("generalCost",billService.getCost(user));
    }
}
