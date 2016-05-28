package by.academy.it.belotserkovsky.command;

//import by.academy.it.belotserkovsky.logic.LoginLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * registration
 * Created by Kostya on 10.04.2016.
 */
public class RegCommand implements ActionCommand {

    private String page = null;

    private static final String UID = "u_id";
    private static final String PARAM_NAME_FIRSTNAME = "firstName";
    private static final String PARAM_NAME_SECONDNAME = "secondName";
    private static final String PARAM_NAME_ADDRESS = "address";
    private static final String PARAM_NAME_PHONE = "phone";
    private static final String PARAM_NAME_EMAIL = "email";
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    /**
     * @param request
     * @param response
     * @return
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) {

//        HttpSession session = request.getSession();
//
//        Long userId = (Long) session.getAttribute(UID);
//        String firstName = request.getParameter(PARAM_NAME_FIRSTNAME);
//        String secondName = request.getParameter(PARAM_NAME_SECONDNAME);
//        String address = request.getParameter(PARAM_NAME_ADDRESS);
//        String phone = request.getParameter(PARAM_NAME_PHONE);
//        String email = request.getParameter(PARAM_NAME_EMAIL);
//        String login = request.getParameter(PARAM_NAME_LOGIN);
//        String pass = request.getParameter(PARAM_NAME_PASSWORD);
//
//        UserDto userDto = new UserDto(userId, firstName, secondName, login, pass, address, phone, email);
//        UserType uType = (UserType) session.getAttribute("userType");
//
//        if (uType == UserType.GUEST && LoginLogic.getInstance().checkUserLogin(login, pass)) {
//            request.setAttribute("errorLoginPassMessage", MessageManager.MESSAGE_LOGIN_PASS_EXISTS);
//            page = ConfigurationManager.PATH_PAGE_REGISTRATION;
//            return page;
//        } else {
//            UserService.getInstance().createOrUpdate(userDto);
//        }
//
//        request.getSession().setAttribute("userType", UserType.GUEST);
//        request.setAttribute("successfulReg", MessageManager.MESSAGE_SUCCESS_REGISTRATION);
//        page = ConfigurationManager.PATH_PAGE_LOGIN;
        return page;
    }
}

