package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Kostya on 01.05.2016.
 */
public class ShowBidFormCommand implements ActionCommand {
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = ConfigurationManager.PATH_PAGE_FORM_BID;
        return page;
    }
}
