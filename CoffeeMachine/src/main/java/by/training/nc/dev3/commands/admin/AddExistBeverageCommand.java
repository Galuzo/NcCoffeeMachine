package by.training.nc.dev3.commands.admin;

import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.commands.Command;
import by.training.nc.dev3.enums.ContentType;
import by.training.nc.dev3.instruments.DataSender;
import by.training.nc.dev3.services.AdminService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Win on 19.04.2017.
 */
public class AddExistBeverageCommand implements Command {
    public String execute(HttpServletRequest request) {
        AdminService adminService=new AdminService();
        int id= Integer.parseInt(request.getParameter("beverageId"));
        int count= Integer.parseInt(request.getParameter("beverageCount"));
        adminService.addExistContent(ContentType.BEVERAGE,id,count);
        User user =(User) request.getSession().getAttribute("user");
        DataSender.sendMainData(request,user);
        return "/jsp/administrator/main.jsp";
    }
}
