package by.academy.it.belotserkovsky.controllers;

import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by K.Belotserkovsky
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers(ModelMap model, @RequestParam(value = "page") String page){
        int currentPage = 1;
        int recordsPerPage = 3;
        if(page != null) {
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
}
