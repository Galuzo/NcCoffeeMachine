package by.training.nc.dev3.controller;

import by.training.nc.dev3.commands.Command;
import by.training.nc.dev3.commands.commandFactory.CommandFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Win on 17.04.2017.
 */

public class Controller extends HttpServlet {

    public Controller(){}

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String page = null;

        CommandFactory commandFactory = CommandFactory.INSTANSE;
        Command command = commandFactory.defineCommand(request);
        page = command.execute(request);
        if(page == null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            System.out.println("null");
            dispatcher.forward(request, response);
        }
        else {
            System.out.println(page);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
