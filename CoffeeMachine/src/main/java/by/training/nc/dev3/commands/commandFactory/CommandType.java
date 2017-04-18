package by.training.nc.dev3.commands.commandFactory;

import by.training.nc.dev3.commands.Command;
import by.training.nc.dev3.commands.user.LoginCommand;
import by.training.nc.dev3.commands.user.RegistrationCommand;

/**
 * Created by Win on 18.04.2017.
 */
public enum CommandType {
    LOGIN,REGISTRATION;

    public Command getCommand() throws EnumConstantNotPresentException
    {
        switch (this) {
            case LOGIN:
                return new LoginCommand();
            case REGISTRATION:
                return new RegistrationCommand();
                default:
                    throw new EnumConstantNotPresentException(this.getDeclaringClass(), this.name());
        }
    }
}
