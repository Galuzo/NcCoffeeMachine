package by.training.nc.dev3.commands.user;

import by.training.nc.dev3.commands.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Win on 20.04.2017.
 */
public class SignOutCommand implements Command {
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return "/index.jsp";
    }
}
