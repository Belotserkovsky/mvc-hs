package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.daoServices.BrigadeDAOService;
import by.academy.it.belotserkovsky.entity.Brigade;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * add brigade
 * Created by Kostya on 11.04.2016.
 */
public class BrigadeAddCommand implements ActionCommand {

    private Brigade brigade = null;

    private static final String PARAM_NAME_NAME = "name";

    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String page = null;
        String name = request.getParameter(PARAM_NAME_NAME);

        brigade = new Brigade();

        brigade.setName(name);

        BrigadeDAOService.getInstance().addBrigade(brigade);

        page = ConfigurationManager.PATH_PAGE_ADMIN;

        return page;
    }
}
