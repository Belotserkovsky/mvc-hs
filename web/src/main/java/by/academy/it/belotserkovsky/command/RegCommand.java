package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.command.ActionCommand;
import by.academy.it.belotserkovsky.command.constants.UserType;
import by.academy.it.belotserkovsky.daoServices.UserDAOService;
import by.academy.it.belotserkovsky.entity.User;
import by.academy.it.belotserkovsky.logic.LoginLogic;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;
import by.academy.it.belotserkovsky.managers.MessageManager;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * registration
 * Created by Kostya on 10.04.2016.
 */
public class RegCommand implements ActionCommand {

    private User user = null;

    private static final String UID = "u_id";
    private static final String PARAM_NAME_FULLNAME = "fullName";
    private static final String PARAM_NAME_ADDRESS = "address";
    private static final String PARAM_NAME_PHONE = "phone";
    private static final String PARAM_NAME_EMAIL = "email";
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    private final int ONE_WEEK = 60*60*24*7;

    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String page = null;
        String fullName = request.getParameter(PARAM_NAME_FULLNAME);
        String address = request.getParameter(PARAM_NAME_ADDRESS);
        String phone = request.getParameter(PARAM_NAME_PHONE);
        String email = request.getParameter(PARAM_NAME_EMAIL);
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);

        if(LoginLogic.getInstance().checkUserLogin(login, pass) == true){
            request.setAttribute("errorLoginPassMessage", MessageManager.MESSAGE_LOGIN_PASS_EXISTS);
            request.getSession().setAttribute("userType", UserType.GUEST);
            page = ConfigurationManager.PATH_PAGE_REGISTRATION;

        }else {

            user = new User();
            user.setFullName(request.getParameter(fullName));
            user.setAddress(request.getParameter(address));
            user.setPhone(request.getParameter(phone));
            user.setEmail(request.getParameter(email));
            user.setLogin(request.getParameter(login));
            user.setPassword(request.getParameter(pass));

            UserDAOService.getInstance().addUser(user);

            user = UserDAOService.getInstance().getUserByLoginPass(login, pass);

            if (user != null){
                request.setAttribute("user", login);
                HttpSession session = request.getSession(true);
                session.setAttribute("userType", UserType.USER);
                Cookie c = new Cookie(UID, String.valueOf(user.getId()));
                c.setMaxAge(ONE_WEEK);
                response.addCookie(c);
                page = ConfigurationManager.PATH_PAGE_USER;
            }
        }
        return page;
    }

}
