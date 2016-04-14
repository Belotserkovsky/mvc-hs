package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.daoServices.BrigadeDAOService;
import by.academy.it.belotserkovsky.entity.Brigade;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Command to add brigade
 * Created by Kostya on 11.04.2016.
 */
public class BrigadeAddCommand implements ActionCommand {

    private static final String PARAM_NAME_USER_ID = "u_id";
    private static final String PARAM_NAME_WORKERS = "workers";

    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String page = "";
        String nameBrigade = "";

        String uid = request.getParameter(PARAM_NAME_USER_ID);

        String[] selected = request.getParameterValues(PARAM_NAME_WORKERS);

        nameBrigade = BrigadeDAOService.getInstance().addBrigade(selected);

        Brigade newBrigade = BrigadeDAOService.getInstance().getBrigadeByName(nameBrigade);

        request.setAttribute("brigade_id", newBrigade.getId());

        return page = ConfigurationManager.PATH_PAGE_FORM_BID;
    }
}
