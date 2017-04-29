package by.training.nc.dev3.commands.user;

import by.training.nc.dev3.commands.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

/**
 * Created by Win on 29.04.2017.
 */
public class GoToSignUp implements Command {
    public String execute(HttpServletRequest request) {
       String url= ResourceBundle.getBundle("pages").getString("path.page.signUp");
        request.getSession().setAttribute("url",url);
        return url;
    }
}
