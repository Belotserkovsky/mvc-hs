package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.daoServices.BidDAOService;
import by.academy.it.belotserkovsky.dto.BidDTO;
import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;
import by.academy.it.belotserkovsky.managers.MessageManager;
import by.academy.it.belotserkovsky.pojos.Brigade;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.SessionImplementor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * add a bid
 * Created by Kostya on 12.04.2016.
 */
public class BidFormCommand implements ActionCommand {
    private static Logger log = Logger.getLogger(BidFormCommand.class);
    Session hibSession = null;

    private static final String PARAM_NAME_USER_ID = "u_id";
    private static final String PARAM_NAME_USER_KIND_OF_WORKS = "kindOfWorks";
    private static final String PARAM_NAME_USER_SCOPE = "scope";
    private static final String PARAM_NAME_USER_DESIRED_RUNTIME = "desiredRuntime";
    private static final String PARAM_NAME_BRIGADE = "brigade";
    private static final String PARAM_NAME_HIB_SESSION = "hibSession";

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        BidDTO bidDTO = null;

        hibSession = (Session)request.getSession().getAttribute(PARAM_NAME_HIB_SESSION);
        SessionImplementor si = (SessionImplementor)hibSession;

        try {
            hibSession.reconnect(si.getJdbcConnectionAccess().obtainConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Long uid = (Long)request.getSession().getAttribute(PARAM_NAME_USER_ID);
        String kindOfWorks = request.getParameter(PARAM_NAME_USER_KIND_OF_WORKS);
        String scope = request.getParameter(PARAM_NAME_USER_SCOPE);
        String desiredRuntime = request.getParameter(PARAM_NAME_USER_DESIRED_RUNTIME);
        Brigade brigade = (Brigade)request.getAttribute(PARAM_NAME_BRIGADE);

        bidDTO = new BidDTO(uid, kindOfWorks, scope, desiredRuntime, brigade);

        try {
            BidDAOService.getInstance().createBid(bidDTO);
        } catch (ExceptionDAO exceptionDAO) {
            exceptionDAO.printStackTrace();
        }

        request.setAttribute("success", MessageManager.MESSAGE_SUCCESS);
        page = ConfigurationManager.PATH_PAGE_USER;
        return page;
    }

}
