package by.academy.it.belotserkovsky.controllers;

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

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String successAuth(){
        return "user/main";
    }

    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String createUser(ModelMap model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "user/registration";
    }

    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    public String updateUser(ModelMap model, @RequestParam (value = "userName") String param){
        UserDto userDto = userService.getUserDto(param);
        model.addAttribute("userDto", userDto);
        return "user/registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createUserFromForm(ModelMap model, @Valid UserDto userDto, BindingResult br) {
        if(br.hasErrors()){
            return "user/registration";
        }
        userService.createOrUpdateUser(userDto);
        model.put("userName", userDto.getUserName());
        return "user/main";
    }

    @RequestMapping(value = "/bidForm", method = RequestMethod.POST)
    public String showBidForm(ModelMap model, @RequestParam (value = "userName") String param){
        model.put("userName", param);
        return "user/bid";
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
