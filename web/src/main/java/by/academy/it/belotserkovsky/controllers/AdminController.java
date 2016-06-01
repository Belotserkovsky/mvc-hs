package by.academy.it.belotserkovsky.controllers;

import by.academy.it.belotserkovsky.dto.BidDto;
import by.academy.it.belotserkovsky.pojos.Bid;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.pojos.constants.Status;
import by.academy.it.belotserkovsky.services.IBidService;
import by.academy.it.belotserkovsky.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by K.Belotserkovsky
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IBidService bidService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainPage(){
        return "admin/main";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, params = "page")
    public String showUsers(ModelMap model, @RequestParam(value = "page") String page){
        int currentPage = 1;
        int recordsPerPage = 3;
        if(page.length() != 0) {
            currentPage = Integer.parseInt(page);
        }
        int allRecords = userService.getRowsUsers();
        List<User> list = userService.getUsers((currentPage-1)*recordsPerPage, recordsPerPage);
        int numberOfPages = (int) Math.ceil((double)allRecords / recordsPerPage);
        model.addAttribute("usersList", list);
        model.addAttribute("numberOfPages", numberOfPages);
        model.addAttribute("currentPage", currentPage);

        return "admin/users";
    }

    @RequestMapping(value = "/bids", method = RequestMethod.GET)
    public String showBids(ModelMap model){
        List<BidDto> list = bidService.getBids();
        List<String> statuses = new ArrayList<String>();
        for(Status status : Status.values()){
            statuses.add(status.getType());
        }
        model.addAttribute("bidDto", new BidDto());
        model.addAttribute("bidsList", list);
        model.addAttribute("statuses", statuses);
        return "admin/bids";
    }

    @RequestMapping(value = "/bids/update", method = RequestMethod.POST)
    public String updateBid(@RequestParam(value = "status") String newStatus,
                            @RequestParam(value = "bidId") String id)
    {
        Bid bid = bidService.getBidById(Long.parseLong(id));
        bid.setStatus(newStatus);
        bidService.updateBid(bid);
        return "redirect: /admin/bids";
    }

    @RequestMapping(value = "/workers", method = RequestMethod.GET)
    public String showWorkers(){
        return "admin/workers";
    }
}
