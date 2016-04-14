package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.command.ActionCommand;
import by.academy.it.belotserkovsky.daoServices.BidDAOService;
import by.academy.it.belotserkovsky.entity.Bid;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * get all user's bids
 * Created by Kostya on 14.04.2016.
 */
public class BidDisplayCommand implements ActionCommand{

    private static final String PARAM_NAME_USER_ID = "u_id";

    public String execute(HttpServletRequest request, HttpServletResponse response){

        String page = null;

        Bid bid = new Bid();

        int uid = Integer.parseInt(request.getParameter(PARAM_NAME_USER_ID));

        Integer key = new Integer(uid);

        bid = BidDAOService.getInstance().getBidByUserID(key);

        request.setAttribute("bid", bid);

        return page;
    }
}
