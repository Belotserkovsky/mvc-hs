package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.daoServices.UserService;
import by.academy.it.belotserkovsky.dto.UserDto;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Kostya on 01.05.2016.
 */
public class EditContactCommand implements ActionCommand {

    private UserDto userDto = null;
    private String page = null;

    private static final String UID = "u_id";

    public String execute(HttpServletRequest request, HttpServletResponse response){

        Long userId = (Long)(request.getSession().getAttribute(UID));

        userDto = UserService.getInstance().getUserDto(userId);

        request.setAttribute("firstName", userDto.getFirstName());
        request.setAttribute("secondName", userDto.getSecondName());
        request.setAttribute("address", userDto.getAddress());
        request.setAttribute("phone", userDto.getPhone());
        request.setAttribute("email", userDto.getEmail());
        request.setAttribute("login", userDto.getLogin());
        request.setAttribute("pass", userDto.getPassword());

        return page = ConfigurationManager.PATH_PAGE_REGISTRATION;
    }

}
