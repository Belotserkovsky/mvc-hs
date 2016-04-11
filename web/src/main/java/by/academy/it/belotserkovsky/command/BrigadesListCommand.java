package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.daoServices.BrigadeDAOService;
import by.academy.it.belotserkovsky.entity.Brigade;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * return the list of available brigades
 * Created by Kostya on 11.04.2016.
 */
public class BrigadesListCommand implements ActionCommand{

    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String page = null;

        List<Brigade> brigadesList = new ArrayList<Brigade>();

        brigadesList = BrigadeDAOService.getInstance().getBrigadesList();

        request.setAttribute("brigadesList", brigadesList);

        return ConfigurationManager.PATH_PAGE_BRIGADESLIST;
    }

}
