package by.training.nc.dev3.commands.user;

import by.training.nc.dev3.beans.Bill;
import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.commands.Command;
import by.training.nc.dev3.dao.implementations.UserDaoImpl;
import by.training.nc.dev3.exceptions.DaoException;
import by.training.nc.dev3.services.CheckUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.GregorianCalendar;

/**
 * Created by Win on 18.04.2017.
 */
public class RegistrationCommand implements Command {


    public String execute(HttpServletRequest request) {
        String page=null;
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User checkUser;
        try {
             checkUser=CheckUserService.isRegistered(name);
            if(checkUser!=null) {
                System.out.println("The user is already consists");
                return "index.jsp";
            }
            else {
                User user = new User(0, name, password, 1);
                UserDaoImpl userDao = new UserDaoImpl();
                user = userDao.persist(user);
                Bill bill = new Bill(0, user.getId(), 0, new GregorianCalendar().getTime());
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "success.jsp";


    }
}
