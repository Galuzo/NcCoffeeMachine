package by.training.nc.dev3.commands.admin;

import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.commands.Command;
import by.training.nc.dev3.enums.ContentType;
import by.training.nc.dev3.instruments.DataSender;
import by.training.nc.dev3.services.AdminService;

import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

/**
 * Created by Win on 20.04.2017.
 */
public class AddNewIngredientCommand implements Command {
    public String execute(HttpServletRequest request) {
        AdminService adminService=new AdminService();
        String title= request.getParameter("newIngredientName");
        String url = ResourceBundle.getBundle("pages").getString("path.page.admin");
        double cost= Double.parseDouble(request.getParameter("newIngredientCost"));
        int count= Integer.parseInt(request.getParameter("newIngredientCount"));
        adminService.addNewContent(ContentType.INGREDIENT,title,cost,count);
        User user =(User) request.getSession().getAttribute("user");
        request.getSession().setAttribute("url",url);
        DataSender.sendMainData(request,user);
        return url;
    }
}
