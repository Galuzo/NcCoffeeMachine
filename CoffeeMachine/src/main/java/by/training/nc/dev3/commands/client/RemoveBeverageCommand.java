package by.training.nc.dev3.commands.client;

import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.commands.Command;
import by.training.nc.dev3.exceptions.DaoException;
import by.training.nc.dev3.instruments.DataSender;
import by.training.nc.dev3.services.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Win on 25.04.2017.
 */
public class RemoveBeverageCommand implements Command {
    public String execute(HttpServletRequest request) {
        int idBeverage = Integer.parseInt(request.getParameter("idBeverage"));
        int idIngredient=0;
        if (request.getParameter("idIngredient")!="") {
             idIngredient = Integer.parseInt(request.getParameter("idIngredient"));
        }
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        ClientService clientService = new ClientService();
        try {
            clientService.removeBeverageFromBill(user,idBeverage,idIngredient);
            DataSender.sendMainData(request,user);
        } catch (DaoException e) {
            request.setAttribute("ingredientError",e.getMessage());
            DataSender.sendMainData(request,user);
        }
        return "/jsp/client/main.jsp";
    }
}
