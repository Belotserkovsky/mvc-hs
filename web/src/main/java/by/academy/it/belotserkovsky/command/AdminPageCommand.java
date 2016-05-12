package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Kostya on 12.05.2016.
 */
public class AdminPageCommand implements ActionCommand {
    private String page = null;

    /**
     * @param request
     * @param response
     * @return page to forward
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = ConfigurationManager.PATH_PAGE_ADMIN;
        return page;
    }
}
