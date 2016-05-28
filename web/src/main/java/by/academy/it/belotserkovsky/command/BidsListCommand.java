package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Get and displaying list of bids
 * Created by Kostya
 */
public class BidsListCommand implements ActionCommand {

    public String execute(HttpServletRequest request, HttpServletResponse response) {

//        List<BidDto> list = BidService.getInstance().getBidsList();
//        List<String> statuses = new ArrayList<String>();
//        for(Status status : Status.values()){
//            statuses.add(status.getType());
//        }
//        request.setAttribute("bidsList", list);
//        request.setAttribute("statuses", statuses);

        return ConfigurationManager.PATH_PAGE_BID_LIST;
    }
}
