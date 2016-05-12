package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.daoServices.BidDAOService;
import by.academy.it.belotserkovsky.dto.BidDTO;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * Get and displaying list of bids
 * Created by Kostya
 */
public class BidsListCommand implements ActionCommand {

    public String execute(HttpServletRequest request, HttpServletResponse response) {

        List<BidDTO> list = BidDAOService.getInstance().getBidsList();

        request.setAttribute("bidsList", list);

        return ConfigurationManager.PATH_PAGE_BID_LIST;
    }
}
