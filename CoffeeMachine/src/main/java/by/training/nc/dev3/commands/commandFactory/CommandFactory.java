package by.training.nc.dev3.commands.commandFactory;

import by.training.nc.dev3.commands.Command;
import by.training.nc.dev3.commands.user.GoTOLoginCommand;
import by.training.nc.dev3.commands.user.LoginCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Win on 18.04.2017.
 */
public enum CommandFactory {
    INSTANSE;

    public Command defineCommand(HttpServletRequest httpRequest) {
        Command command=null;
        String commandName = httpRequest.getParameter("command");
        try{
            CommandType type = CommandType.valueOf(commandName.toUpperCase());
            command = type.getCommand();
        }
        catch(NullPointerException e){
            command = new GoTOLoginCommand();
        }
        catch(IllegalArgumentException e){
            command = new GoTOLoginCommand();
        }
        return command;
    }
}
