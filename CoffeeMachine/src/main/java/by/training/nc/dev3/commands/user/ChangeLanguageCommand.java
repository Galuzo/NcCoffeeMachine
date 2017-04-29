package by.training.nc.dev3.commands.user;

import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.commands.Command;
import by.training.nc.dev3.instruments.DataSender;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Win on 28.04.2017.
 */
public class ChangeLanguageCommand implements Command {
    public String execute(HttpServletRequest request) {
        //Locale lang = (Locale)request.getSession().getAttribute("language");
        String language= request.getParameter("language");
        Locale lang = new Locale(language);
        request.getSession().setAttribute("language",lang);
        String url = (String)request.getSession().getAttribute("url");
        if (url == null) {
            url = ResourceBundle.getBundle("pages").getString("path.page.user");
        }
        User user = (User) request.getSession().getAttribute("user");
        DataSender.sendMainData(request,user);
        return url;
    }
}
