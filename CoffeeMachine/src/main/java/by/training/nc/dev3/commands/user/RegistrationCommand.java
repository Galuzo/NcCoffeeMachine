package by.training.nc.dev3.commands.user;

import by.training.nc.dev3.beans.Bill;
import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.commands.Command;
import by.training.nc.dev3.dao.implementations.BillDaoImpl;
import by.training.nc.dev3.dao.implementations.UserDaoImpl;
import by.training.nc.dev3.exceptions.DaoException;
import by.training.nc.dev3.instruments.DataSender;
import by.training.nc.dev3.services.CheckUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        HttpSession httpSession=request.getSession();
        User checkUser;
        try {
             checkUser=CheckUserService.isRegistered(name);
            if(checkUser!=null) {

                httpSession.setAttribute("error","The user is already registered");
                return "/jsp/signUp.jsp";
            }
            else {
                User user = new User(0, name, password, 1);
                UserDaoImpl userDao = new UserDaoImpl();
                BillDaoImpl billDao = new BillDaoImpl();
                user = userDao.persist(user);
                Bill bill = new Bill(0, user.getId(), 0, new GregorianCalendar().getTime());
                billDao.persist(bill);
                httpSession.setAttribute("user",user);
                DataSender.sendMainData(request,user);
                httpSession.removeAttribute("error");
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "/jsp/client/main.jsp";


    }
}
