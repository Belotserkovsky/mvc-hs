package by.academy.it.belotserkovsky.command;

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
    private static final String PARAM_NAME_FIRSTNAME = "firstName";
    private static final String PARAM_NAME_SECONDNAME = "secondName";
    private static final String PARAM_NAME_ADDRESS = "address";
    private static final String PARAM_NAME_PHONE = "phone";
    private static final String PARAM_NAME_EMAIL = "email";
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    public String execute(HttpServletRequest request, HttpServletResponse response){



        return page = ConfigurationManager.PATH_PAGE_REGISTRATION;
    }

}
