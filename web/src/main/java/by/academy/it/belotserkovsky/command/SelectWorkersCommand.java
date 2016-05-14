package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.daoServices.BrigadeService;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;
import by.academy.it.belotserkovsky.managers.MessageManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Workers select query processing
 * Created by K.Belotsekovsky
 */
public class SelectWorkersCommand implements ActionCommand {

    private static final String PARAM_NAME_WORKERS = "workers";
    private static final String PARAM_NAME_BID_ID = "bidId";

    /**
     * @param request
     * @param response
     * @return String user'sPage
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        String nameBrigade = "";

        String[] selected = request.getParameterValues(PARAM_NAME_WORKERS);
        Long bidId = (Long)request.getSession().getAttribute(PARAM_NAME_BID_ID);

        BrigadeService.getInstance().createBrigade(selected, bidId);

        page = ConfigurationManager.PATH_PAGE_USER;
        request.setAttribute("success", MessageManager.MESSAGE_SUCCESS);
        return page;
    }
}
