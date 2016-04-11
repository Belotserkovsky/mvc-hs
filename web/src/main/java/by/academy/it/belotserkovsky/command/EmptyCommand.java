package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.command.ActionCommand;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *in the event of an error or a direct appeal to the controller
 * redirecting to login page
 * Created by Kostya on 09.04.2016.
 */
public class EmptyCommand implements ActionCommand {

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = ConfigurationManager.PATH_PAGE_LOGIN;
        return page;
    }
}
