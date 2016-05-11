package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.daoServices.BrigadeDAOService;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;
import by.academy.it.belotserkovsky.managers.MessageManager;
import by.academy.it.belotserkovsky.pojos.Brigade;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by Kostya on 04.05.2016.
 */
public class SelectWorkersCommand implements ActionCommand {
    private Session hibSession = null;
    private Transaction transaction = null;

    private static final String PARAM_NAME_WORKERS = "workers";

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        String nameBrigade = "";

        String[] selected = request.getParameterValues(PARAM_NAME_WORKERS);
        Brigade newBrigade = BrigadeDAOService.getInstance().createBrigade(selected);
        page = ConfigurationManager.PATH_PAGE_FORM_BID;

        return page;
    }
}
