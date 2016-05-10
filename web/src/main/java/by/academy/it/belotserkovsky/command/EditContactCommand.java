package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.daoServices.UserDAOService;
import by.academy.it.belotserkovsky.dto.UserDTO;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Kostya on 01.05.2016.
 */
public class EditContactCommand implements ActionCommand {

    private UserDTO userDTO = null;
    private String page = null;

    private static final String UID = "u_id";

    public String execute(HttpServletRequest request, HttpServletResponse response){

        Long uid = (Long)(request.getSession().getAttribute(UID));
        userDTO = UserDAOService.getInstance().getUserWithContact(uid);

        request.setAttribute("firstName", userDTO.getFirstName());
        request.setAttribute("secondName", userDTO.getSecondName());
        request.setAttribute("address", userDTO.getAddress());
        request.setAttribute("phone", userDTO.getPhone());
        request.setAttribute("email", userDTO.getEmail());
        request.setAttribute("login", userDTO.getLogin());
        request.setAttribute("pass", userDTO.getPassword());

        return page = ConfigurationManager.PATH_PAGE_REGISTRATION;
    }

}
