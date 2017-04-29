package by.training.nc.dev3.commands.user;

import by.training.nc.dev3.beans.Bill;
import by.training.nc.dev3.beans.Content;
import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.commands.Command;
import by.training.nc.dev3.exceptions.DaoException;
import by.training.nc.dev3.instruments.DataSender;
import by.training.nc.dev3.services.BillService;
import by.training.nc.dev3.services.CheckUserService;
import by.training.nc.dev3.services.CoffeeMachineService;
import filters.UserType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Win on 18.04.2017.
 */
public class LoginCommand implements Command {
    public String execute(HttpServletRequest request) {
        String page=null;
        String login = request.getParameter("name");
        String password = request.getParameter("password");
        HttpSession httpSession = request.getSession();
        Locale local=new Locale((String)request.getSession().getAttribute("language"));
        User user = CheckUserService.isRegistered(login);
            if(user!=null) {
                if (password.equals(user.getPassword())) {
                    httpSession = request.getSession(true);
                    httpSession.setAttribute("user", user);
                    UserType userType = CheckUserService.defineRole(user);
                    httpSession.setAttribute("userType", userType);
                    request.removeAttribute("name");
                    request.removeAttribute("password");
                     login = request.getParameter("name");
                    switch (userType) {
                        case ADMINISTRATOR:
                            String url = ResourceBundle.getBundle("pages").getString("path.page.admin");
                            request.getSession().setAttribute("url",url);
                            DataSender.sendMainData(request, user);
                            page = url;
                            break;
                        case ClIENT:
                            url = ResourceBundle.getBundle("pages").getString("path.page.client");
                            request.getSession().setAttribute("url",url);
                            DataSender.sendMainData(request, user);
                            page = url;
                            break;
                    }

                } else {
                    String url = ResourceBundle.getBundle("pages").getString("path.page.user");
                    request.getSession().setAttribute("url",url);
                    httpSession.setAttribute("error", ResourceBundle.getBundle("Messages",local).getString("error.label.wrongPassword"));
                    page = url;
                }
            }
            else {
                String url = ResourceBundle.getBundle("pages").getString("path.page.user");
                request.getSession().setAttribute("url",url);
                httpSession.setAttribute("error", ResourceBundle.getBundle("Messages",local).getString("error.label.wrongLogin"));
                page = url;
            }
        return page;
    }
}
