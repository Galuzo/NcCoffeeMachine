package by.training.nc.dev3.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Win on 17.04.2017.
 */
public interface Command {
    String execute(HttpServletRequest request);
}
