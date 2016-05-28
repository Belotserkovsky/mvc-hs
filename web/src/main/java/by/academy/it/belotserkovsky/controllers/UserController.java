package by.academy.it.belotserkovsky.controllers;

import by.academy.it.belotserkovsky.services.IUserService;
import by.academy.it.belotserkovsky.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by K.Belotserkovsky
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String createUser(ModelMap modelMap){
        UserDto userDto = new UserDto();
        modelMap.addAttribute("userDto", userDto);
        return "user/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addPerson(ModelMap model, @Valid UserDto userDto, BindingResult br) {

        if(br.hasErrors()){
            return "user/registration";
        }
        userService.createOrUpdateUser(userDto);
        if(!br.hasErrors()) {
            if (person != null) {
                Person p = new Person();
                p.setAge(person.getAge());
                p.setId(p.getId());
                p.setName(p.getName());
                p.setSurname(p.getSurname());
                p = personService.create(p);
                model.put("person", p);
            }
        }
        model.put("persons", personService.getPersons());
        return "persons/main";
    }
}
