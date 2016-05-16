package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.daoServices.BidService;
import by.academy.it.belotserkovsky.dto.BidDto;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * add a bid
 * Created by Kostya on 12.04.2016.
 */
public class BidFormCommand implements ActionCommand {
    private static Logger log = Logger.getLogger(BidFormCommand.class);

    private static final String PARAM_NAME_USER_ID = "u_id";
    private static final String PARAM_NAME_USER_KIND_OF_WORKS = "kindOfWorks";
    private static final String PARAM_NAME_USER_SCOPE = "scope";
    private static final String PARAM_NAME_USER_DESIRED_RUNTIME = "desiredRuntime";
    private static final String PARAM_NAME_BID_ID = "bidId";

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        BidDto bidDto = null;

        Long uid = (Long)request.getSession().getAttribute(PARAM_NAME_USER_ID);
        String kindOfWorks = request.getParameter(PARAM_NAME_USER_KIND_OF_WORKS);
        String scope = request.getParameter(PARAM_NAME_USER_SCOPE);
        String desiredRuntime = request.getParameter(PARAM_NAME_USER_DESIRED_RUNTIME);

        bidDto = new BidDto(uid, kindOfWorks, scope, desiredRuntime);

        Long bidId = BidService.getInstance().createBid(bidDto);

        request.getSession().setAttribute(PARAM_NAME_BID_ID, bidId);

        page = ConfigurationManager.PATH_PAGE_SELECT_WORKERS;
        return page;
    }

}
