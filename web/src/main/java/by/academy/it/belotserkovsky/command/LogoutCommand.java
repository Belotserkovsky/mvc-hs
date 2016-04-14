package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * session destruction
 * Created by Kostya on 09.04.2016.
 */
public class LogoutCommand implements ActionCommand {

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = ConfigurationManager.PATH_PAGE_LOGOUT;
        request.getSession().invalidate();
        return page;
    }

}
