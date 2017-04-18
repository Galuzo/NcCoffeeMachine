package by.training.nc.dev3.commands.user;

import by.training.nc.dev3.commands.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Win on 18.04.2017.
 */
public class LoginCommand implements Command {
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("name");
        return login;
    }
}
