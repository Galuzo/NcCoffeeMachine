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
 * Created by Win on 20.04.2017.
 */
public class AddBeverageInBillCommand implements Command {
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user =(User) request.getSession().getAttribute("user");
        String url = ResourceBundle.getBundle("pages").getString("path.page.client");
        if(user!=null) {
            ClientService clientService = new ClientService();
            try {
                clientService.addBeverageInBill(user, id);
                DataSender.sendMainData(request, user);
            } catch (DaoException e) {
                request.setAttribute("ingredientError", e.getCause().getMessage());
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
