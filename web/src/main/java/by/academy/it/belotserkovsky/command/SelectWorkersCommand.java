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

/**
 * Created by Kostya on 04.05.2016.
 */
public class SelectWorkersCommand implements ActionCommand {
    private Session hibSession = null;
    private Transaction transaction = null;

    private final String PARAM_NAME_USER_ID = "u_id";
    private final String PARAM_NAME_WORKERS = "workers";
    private final String PARAM_NAME_HIBSESSION = "hibernateSession";

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "";
        String nameBrigade = "";

        hibSession = (Session)request.getSession().getAttribute(PARAM_NAME_HIBSESSION);
        hibSession.reconnect();

        String uid = request.getParameter(PARAM_NAME_USER_ID);

        String[] selected = request.getParameterValues(PARAM_NAME_WORKERS);

        Brigade newBrigade  = BrigadeDAOService.getInstance().create(selected);

        transaction = hibSession.getTransaction();
        transaction.commit();
        HibernateUtil.closeSession();

        request.setAttribute("success", MessageManager.MESSAGE_SUCCESS);
        return page = ConfigurationManager.PATH_PAGE_USER;
    }
}
