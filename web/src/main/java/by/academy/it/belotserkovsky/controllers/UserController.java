package by.academy.it.belotserkovsky.controllers;

import by.academy.it.belotserkovsky.dao.BidDao;
import by.academy.it.belotserkovsky.dto.BidDto;
import by.academy.it.belotserkovsky.pojos.constants.DesiredRuntime;
import by.academy.it.belotserkovsky.pojos.constants.KindOfWork;
import by.academy.it.belotserkovsky.services.BidService;
import by.academy.it.belotserkovsky.services.IBidService;
import by.academy.it.belotserkovsky.services.IBrigadeService;
import by.academy.it.belotserkovsky.services.IUserService;
import by.academy.it.belotserkovsky.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by K.Belotserkovsky
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IBidService bidService;

    @Autowired
    private IBrigadeService brigadeService;

    @RequestMapping(value = "/main", method = RequestMethod.GET, params = "successAuth")
    public String successAuth(){
        return "user/main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET, params = "successAddBid")
    public String successCreationBid(){
        return "user/main";
    }

    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String createUser(ModelMap model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "user/registration";
    }

    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    public String updateUser(ModelMap model, @RequestParam (value = "userName") String name){
        UserDto userDto = userService.getUserDto(name);
        model.addAttribute("userDto", userDto);
        return "user/registration";
    }

    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public String createUserFromForm(@Valid UserDto userDto, BindingResult br) {
        if(br.hasErrors()){
            return "user/registration";
        }
        userService.createOrUpdateUser(userDto);
//        model.put("userName", userDto.getUserName());
        return "redirect: /j_spring_security_check";
    }

    @RequestMapping(value = "/bidForm", method = RequestMethod.POST)
    public String showBidForm(ModelMap model, @RequestParam (value = "userName") String param){
        model.put("userName", param);
        model.put("kindsOfWorks", KindOfWork.values());
        model.put("variantsRuntime", DesiredRuntime.values());
        return "user/bid";
    }

    @RequestMapping(value = "/createBid", method = RequestMethod.POST)
        public String createBid(@RequestParam (value = "selected") String[] selectedWorks,
                                @RequestParam (value = "desiredRuntime") String selectedRuntime,
                                @RequestParam (value = "scope") String scope,
                                @RequestParam (value = "userName") String name)
        {
            BidDto bidDto = new BidDto(name, scope, selectedRuntime);
            Long bidId = bidService.createBid(bidDto);
            brigadeService.createBrigade(selectedWorks, bidId);

        return "redirect: /user/main?success";
        }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

}
