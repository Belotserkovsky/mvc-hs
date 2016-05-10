package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.command.constants.UserType;
import by.academy.it.belotserkovsky.daoServices.UserDAOService;
import by.academy.it.belotserkovsky.dto.UserDTO;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.logic.LoginLogic;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;
import by.academy.it.belotserkovsky.managers.MessageManager;
import by.academy.it.belotserkovsky.pojos.UserContacts;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * registration
 * Created by Kostya on 10.04.2016.
 */
public class RegCommand implements ActionCommand {

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
    private final int ONE_WEEK = 60*60*24*7;

    /**
     * @param request
     * @param response
     * @return
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();

        Long uid = (Long)session.getAttribute(UID);
        String firstName = request.getParameter(PARAM_NAME_FIRSTNAME);
        String secondName = request.getParameter(PARAM_NAME_SECONDNAME);
        String address = request.getParameter(PARAM_NAME_ADDRESS);
        String phone = request.getParameter(PARAM_NAME_PHONE);
        String email = request.getParameter(PARAM_NAME_EMAIL);
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);

        UserType uType = (UserType)session.getAttribute("userType");

        if(LoginLogic.getInstance().checkUserLogin(login, pass) && uType == UserType.GUEST){
            request.setAttribute("errorLoginPassMessage", MessageManager.MESSAGE_LOGIN_PASS_EXISTS);
            //request.getSession().setAttribute("userType", UserType.GUEST);
            page = ConfigurationManager.PATH_PAGE_REGISTRATION;
            return page;

        }else {
            if(uid != null) {
                userDTO = UserDAOService.getInstance().getUserWithContact(uid);
                userDTO.setFirstName(firstName);
                userDTO.setSecondName(secondName);
                userDTO.setLogin(login);
                userDTO.setPassword(pass);
                userDTO.setAddress(address);
                userDTO.setPhone(phone);
                userDTO.setEmail(email);
                UserDAOService.getInstance().createOrUpdate(userDTO);
            }else {
                userDTO = new UserDTO(firstName, secondName, login, pass, address, phone, email);
                UserDAOService.getInstance().createOrUpdate(userDTO);
                userDTO = UserDAOService.getInstance().getUserByLoginPass(login, pass);
                session.setAttribute("user", userDTO.getFirstName());
                session.setAttribute("u_id", userDTO.getUid());
                session.setAttribute("userType", UserType.USER);
                Cookie c = new Cookie(UID, String.valueOf(userDTO.getUid()));
                c.setMaxAge(ONE_WEEK);
                response.addCookie(c);
            }

            request.setAttribute("success", MessageManager.MESSAGE_SUCCESS);
            page = ConfigurationManager.PATH_PAGE_USER;
            return page;
        }
    }
}
