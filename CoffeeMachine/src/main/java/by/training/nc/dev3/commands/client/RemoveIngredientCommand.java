package by.training.nc.dev3.commands.client;

import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.commands.Command;
import by.training.nc.dev3.exceptions.DaoException;
import by.training.nc.dev3.instruments.DataSender;
import by.training.nc.dev3.services.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ResourceBundle;

/**
 * Created by Win on 25.04.2017.
 */
public class RemoveIngredientCommand implements Command{
    public String execute(HttpServletRequest request) {
        int idBeverage=Integer.parseInt(request.getParameter("idBeverage"));
        int idIngredient=Integer.parseInt(request.getParameter("idIngredient"));
        HttpSession httpSession = request.getSession();
        String url = ResourceBundle.getBundle("pages").getString("path.page.client");

        User user=(User)httpSession.getAttribute("user");
        ClientService clientService = new ClientService();
        try {
            clientService.removeIngredientFromBill(user,idBeverage,idIngredient);
            DataSender.sendMainData(request, user);
        } catch (DaoException e) {
            DataSender.sendMainData(request, user);
            request.setAttribute("ingredientError",e.getMessage());
        }
        request.getSession().setAttribute("url",url);
        return url;
    }
}
