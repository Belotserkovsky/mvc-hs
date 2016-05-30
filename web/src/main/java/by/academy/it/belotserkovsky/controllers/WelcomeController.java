package by.academy.it.belotserkovsky.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by K.Belotserkovsky
 */

@Controller
@RequestMapping("/home")
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String welcomePage(){ return "login"; }

//    @RequestMapping(value = "login", method = RequestMethod.GET)
//    public String loginPage() {
//        return "login";
//    }

    @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
    public String accessDenied(){
        return "access_denied";
    }
}
