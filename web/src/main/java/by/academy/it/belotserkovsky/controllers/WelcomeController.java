package by.academy.it.belotserkovsky.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by K.Belotserkovsky
 */

@Controller
public class WelcomeController {

    /**
     * @return String page
     * mapping "/home"
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String welcomePage(){
        return "login";
    }

//    @RequestMapping(value = "/home", method = RequestMethod.GET)
//    public String welcomePage(){
//        return "test";
//    }

    /**
     * @return String page
     * mapping /login?logout
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET, params = "logout")
    public String logout() {
        return "login";
    }

    /**
     * @return String page
     * mapping "/login?logn"
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET, params = "login")
    public String loginAfterRegister() {
        return "login";
    }

    /**
     * @return String page
     * mapping "/home?loginFail"
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET, params = "loginFail")
    public String accessDenied(){
        return "login";
    }
}
