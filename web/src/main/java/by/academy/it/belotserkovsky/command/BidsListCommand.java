package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.daoServices.BidDAOService;
import by.academy.it.belotserkovsky.entity.Bid;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * get and displaying list of bids
 * Created by Kostya
 */
public class BidsListCommand implements ActionCommand {

    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String page = null;

        List<Bid> bidsList = new ArrayList<Bid>();

        bidsList = BidDAOService.getInstance().getBidsList();

        request.setAttribute("bidsList", bidsList);

        return ConfigurationManager.PATH_PAGE_BID_LIST;
    }
}
