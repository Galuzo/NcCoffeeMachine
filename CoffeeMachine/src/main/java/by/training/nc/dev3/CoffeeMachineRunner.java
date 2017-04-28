package by.training.nc.dev3;

import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.enums.ContentType;
import by.training.nc.dev3.services.AdminService;
import by.training.nc.dev3.services.BillService;
import by.training.nc.dev3.services.ClientService;
import by.training.nc.dev3.services.CoffeeMachineService;


/**
 * Created by Win on 18.03.2017.
 */
public class CoffeeMachineRunner {
    public static void main(String[] args) {
    CoffeeMachineService coffeeMachineService=new CoffeeMachineService();
    ClientService clientService=new ClientService();
        BillService billService = new BillService();
        User user = new User(1, "galuzo", "dasd", 1);
    AdminService adminService=new AdminService();
    adminService.addExistContent(ContentType.INGREDIENT,1,10);
    adminService.addNewContent(ContentType.INGREDIENT,"Milk",1.2,5);
   // clientService.addBeverageInBill(user,1);
    coffeeMachineService.showAssortiment();
   // clientService.addIngredient(user,1,1);
    //billService.showResultBill(user);
    //clientService.addIngredient(user,1,1);
   // clientService.addBeverageInBill(user,3);
    //clientService.removeIngredientFromBill(user,4,1);
   // billService.showResultBill(user);
    //clientService.removeBeverageFromBill(user,2);

   //clientService.addIngredient(user,1,1);
        /*MenuInitialisation.Initialiaze();
        MenuInitialisation.showMenu();*/
    }
}
