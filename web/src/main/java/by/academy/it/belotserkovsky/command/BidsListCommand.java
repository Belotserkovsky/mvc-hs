package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.daoServices.BidService;
import by.academy.it.belotserkovsky.dto.BidDto;
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

        List<BidDto> list = BidService.getInstance().getBidsList();

        request.setAttribute("bidsList", list);

        return ConfigurationManager.PATH_PAGE_BID_LIST;
    }
}
