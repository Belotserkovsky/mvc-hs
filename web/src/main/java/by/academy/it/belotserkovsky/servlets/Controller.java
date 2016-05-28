package by.academy.it.belotserkovsky.servlets;

import by.academy.it.belotserkovsky.command.ActionCommand;
import by.academy.it.belotserkovsky.command.factory.ActionFactory;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;
import by.academy.it.belotserkovsky.managers.MessageManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1)define command which came from a JSP
 * 2) call implemented execute () method, and passing parameters to the class-specific command handler
 * 3) Set the message page error
 * Created by Kostya on 09.04.2016.
 */

//@WebServlet("/controllers")
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String page = null;
        ActionFactory factory = new ActionFactory();
        ActionCommand command = factory.defineCommand(request, response);
        page = command.execute(request, response);
        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            page = ConfigurationManager.PATH_PAGE_INDEX;
            request.getSession().setAttribute("nullPage", MessageManager.MESSAGE_NULL_PAGE);
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
