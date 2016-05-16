package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.command.constants.UserType;
import by.academy.it.belotserkovsky.daoServices.UserService;
import by.academy.it.belotserkovsky.dto.UserDto;
import by.academy.it.belotserkovsky.logic.LoginLogic;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;
import by.academy.it.belotserkovsky.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

/**
 * Define type users and redirecting to the appropriate page
 * Created by Kostya on 09.04.2016.
 */
public class LoginCommand implements ActionCommand {

    private final String UID = "u_id";
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private final int ONE_WEEK = 60*60*24*7;

    /**
     * @param request
     * @param response
     * @return page to forward
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);

        HttpSession session = request.getSession();
        UserDto userDto = UserService.getInstance().getUserByLoginPass(login, pass);

        if (LoginLogic.getInstance().checkAdminLogin(login, pass)) {
            session.setAttribute("userType", UserType.ADMIN);
            session.setAttribute("user", login);
            page = ConfigurationManager.PATH_PAGE_ADMIN;
            return page;
        } else if (userDto != null) {
            session.setAttribute("user", userDto.getFirstName());
            session.setAttribute("u_id", userDto.getUid());
            session.setAttribute("userType", UserType.USER);
            Cookie c = new Cookie(UID, String.valueOf(userDto.getUid()));
            c.setMaxAge(ONE_WEEK);
            response.addCookie(c);
            page = ConfigurationManager.PATH_PAGE_USER;
            return page;
        }
        else {
            request.setAttribute("errorLoginPassMessage", MessageManager.MESSAGE_LOGIN_ERROR);
            session.setAttribute("userType", UserType.GUEST);
            page = ConfigurationManager.PATH_PAGE_LOGIN;
            return page;
        }
    }
}
