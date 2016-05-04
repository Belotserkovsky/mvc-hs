package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.daoServices.BidDAOService;
import by.academy.it.belotserkovsky.dto.BidDTO;
import by.academy.it.belotserkovsky.pojos.Bid;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;
import by.academy.it.belotserkovsky.managers.MessageManager;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * add a bid
 * Created by Kostya on 12.04.2016.
 */
public class BidFormCommand implements ActionCommand {
    private Bid newBid = null;
    private Session hibSession = null;
    private Transaction transaction = null;

    private static final String PARAM_NAME_USER_ID = "u_id";
    private static final String PARAM_NAME_USER_KIND_OF_WORKS = "kindOfWorks";
    private static final String PARAM_NAME_USER_SCOPE = "scope";
    private static final String PARAM_NAME_USER_DESIRED_RUNTIME = "desiredRuntime";

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        BidDTO bidDTO = null;

        hibSession = HibernateUtil.getSession();
        transaction = hibSession.beginTransaction();

        String uid = request.getParameter(PARAM_NAME_USER_ID);
        String kindOfWorks = request.getParameter(PARAM_NAME_USER_KIND_OF_WORKS);
        String scope = request.getParameter(PARAM_NAME_USER_SCOPE);
        String desiredRuntime = request.getParameter(PARAM_NAME_USER_DESIRED_RUNTIME);

        bidDTO = new BidDTO(Long.parseLong(uid), kindOfWorks, scope, desiredRuntime);
        BidDAOService.getInstance().create(bidDTO);

        request.getSession().setAttribute("hibernateSession", hibSession);
        hibSession.disconnect();

        return page = ConfigurationManager.PATH_PAGE_SELECT_WORKERS;
    }

}
