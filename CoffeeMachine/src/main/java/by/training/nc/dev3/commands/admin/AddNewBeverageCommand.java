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
public class AddNewBeverageCommand implements Command {
    public String execute(HttpServletRequest request) {
        AdminService adminService=new AdminService();
        String title= request.getParameter("newBeverageName");
        String url = ResourceBundle.getBundle("pages").getString("path.page.admin");
        double cost= Double.parseDouble(request.getParameter("newBeverageCost"));
        int count= Integer.parseInt(request.getParameter("newBeverageCount"));
        adminService.addNewContent(ContentType.BEVERAGE,title,cost,count);
        User user =(User) request.getSession().getAttribute("user");
        DataSender.sendMainData(request,user);
        request.getSession().setAttribute("url",url);
        return url;
    }
}
