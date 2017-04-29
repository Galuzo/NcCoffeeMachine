package by.training.nc.dev3.commands.client;

import by.training.nc.dev3.beans.Content;
import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.commands.Command;
import by.training.nc.dev3.dao.implementations.IngredientDaoImpl;
import by.training.nc.dev3.exceptions.DaoException;
import by.training.nc.dev3.instruments.DataSender;
import by.training.nc.dev3.services.ClientService;

import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

/**
 * Created by Win on 22.04.2017.
 */
public class AddIngredientInBillCommand implements Command {
    public String execute(HttpServletRequest request) {
        IngredientDaoImpl ingredientDao = new IngredientDaoImpl();
        int idBeverage = Integer.parseInt(request.getParameter("idBeverage"));
        String titleIngredient=request.getParameter("selectedIngredient");
        String url = ResourceBundle.getBundle("pages").getString("path.page.client");
        User user =(User) request.getSession().getAttribute("user");
        if(user!=null) {
            try {
                Content ingredient = ingredientDao.getByTitle(titleIngredient);
                ClientService clientService = new ClientService();
                clientService.addIngredient(user,idBeverage,ingredient.getId());
                DataSender.sendMainData(request, user);
            } catch (DaoException e) {
                request.setAttribute("ingredientError", e.getMessage());
                DataSender.sendMainData(request, user);
            }
            request.getSession().setAttribute("url",url);
            return url;
        }
        else
        {
            url = ResourceBundle.getBundle("pages").getString("path.page.user");
            request.getSession().setAttribute("url",url);
            return url;
        }
    }
}
