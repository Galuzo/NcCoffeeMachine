package by.training.nc.dev3;

import by.training.nc.dev3.beans.User;
import by.training.nc.dev3.enums.ContentType;
import by.training.nc.dev3.services.AdminService;
import by.training.nc.dev3.services.BillService;
import by.training.nc.dev3.services.ClientService;
import by.training.nc.dev3.services.CoffeeMachineService;

import java.util.Locale;
import java.util.ResourceBundle;


/**
 * Created by Win on 18.03.2017.
 */
public class CoffeeMachineRunner {
    public static void main(String[] args) {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("text",new Locale("en"));
        System.out.println(resourceBundle.getString("login.button.submit"));
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
