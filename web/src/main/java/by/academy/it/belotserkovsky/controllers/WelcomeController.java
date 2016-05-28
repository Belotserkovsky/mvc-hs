package by.academy.it.belotserkovsky.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by K.Belotserkovsky
 */

@Controller
@RequestMapping({"/", "/login"})
public class WelcomeController {

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String loginPage(){ return "login"; }

}
