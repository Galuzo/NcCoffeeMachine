package by.training.nc.dev3.commands.commandFactory;

import by.training.nc.dev3.commands.Command;
import by.training.nc.dev3.commands.client.AddIngredientInBillCommand;
import by.training.nc.dev3.commands.client.RemoveBeverageCommand;
import by.training.nc.dev3.commands.client.RemoveIngredientCommand;
import by.training.nc.dev3.commands.user.*;
import by.training.nc.dev3.commands.admin.AddExistBeverageCommand;
import by.training.nc.dev3.commands.admin.AddNewBeverageCommand;
import by.training.nc.dev3.commands.admin.AddExistIngredientCommand;
import by.training.nc.dev3.commands.admin.AddNewIngredientCommand;
import by.training.nc.dev3.commands.client.AddBeverageInBillCommand;

/**
 * Created by Win on 18.04.2017.
 */
public enum CommandType {
    LOGIN,GOTOSIGNUP,REGISTRATION,SIGNOUT,CHANGELANGUAGE,

    ADDEXISTBEVERAGE,ADDNEWBEVERAGE,ADDEXISTINGREDIENT,ADDNEWINGREDIENT,

    ADDBEVERAGEINBILL,ADDINGREDIENTINBILL,REMOVEINGREDIENTFROMBILL,REMOVEBEVERAGEFROMBILL;
    public Command getCommand() throws EnumConstantNotPresentException
    {
        switch (this) {
            case LOGIN:
                return new LoginCommand();
            case GOTOSIGNUP:
                return new GoToSignUp();
            case REGISTRATION:
                return new RegistrationCommand();
            case ADDEXISTBEVERAGE:
                return new AddExistBeverageCommand();
            case ADDNEWBEVERAGE:
                return new AddNewBeverageCommand();
            case ADDEXISTINGREDIENT:
                return new AddExistIngredientCommand();
            case ADDNEWINGREDIENT:
                return new AddNewIngredientCommand();
            case SIGNOUT:
                return new SignOutCommand();
            case ADDBEVERAGEINBILL:
                return new AddBeverageInBillCommand();
            case ADDINGREDIENTINBILL:
                return new AddIngredientInBillCommand();
            case REMOVEINGREDIENTFROMBILL:
                return new RemoveIngredientCommand();
            case REMOVEBEVERAGEFROMBILL:
                return new RemoveBeverageCommand();
            case CHANGELANGUAGE:
                return new ChangeLanguageCommand();
                default:
                    throw new EnumConstantNotPresentException(this.getDeclaringClass(), this.name());
        }
    }
}
