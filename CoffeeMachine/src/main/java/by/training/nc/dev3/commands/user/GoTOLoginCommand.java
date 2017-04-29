package by.training.nc.dev3.commands.user;

import by.training.nc.dev3.commands.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Win on 23.04.2017.
 */
public class GoTOLoginCommand implements Command {
    public String execute(HttpServletRequest request) {
        request.getSession().setAttribute("url","/index.jsp");
        return "/index.jsp";
    }
}
