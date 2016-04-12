package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.daoServices.BidDAOService;
import by.academy.it.belotserkovsky.entity.Bid;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * add a bid
 * Created by Kostya on 12.04.2016.
 */
public class BidFormCommand implements ActionCommand {
    Bid newBid = null;

    private static final String PARAM_NAME_USER_ID = "u_id";
    private static final String PARAM_NAME_USER_KIND_OF_WORKS = "kindOfWorks";
    private static final String PARAM_NAME_USER_SCOPE = "scope";
    private static final String PARAM_NAME_USER_DESIRED_RUNTIME = "desiredRuntime";

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        String uid = request.getParameter(PARAM_NAME_USER_ID);
        String kindOfWorks = request.getParameter(PARAM_NAME_USER_KIND_OF_WORKS);
        String scope = request.getParameter(PARAM_NAME_USER_SCOPE);
        String desiredRuntime = request.getParameter(PARAM_NAME_USER_DESIRED_RUNTIME);

        newBid = new Bid ();
        newBid.setKindOfWorks(kindOfWorks);
        newBid.setScope(scope);
        newBid.setDesiredRuntime(desiredRuntime);
        newBid.setUserId(Integer.parseInt(uid));

        BidDAOService.getInstance().addBid(newBid);

        return ConfigurationManager.PATH_PAGE_CHOICE_WORKER;
    }

}
