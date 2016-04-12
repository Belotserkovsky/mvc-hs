package by.academy.it.belotserkovsky.logic;

import by.academy.it.belotserkovsky.daoServices.UserDAOService;

/**
 *
 * Created by Kostya on 09.04.2016.
 */
public class LoginLogic {
    private static LoginLogic instance;

    private final static String ADMIN_LOGIN = "admin";
    private final static String ADMIN_PASS = "admin";

    private LoginLogic() {
        super();
    }

    public static LoginLogic getInstance() {
        if (instance == null) {
            instance = new LoginLogic();
        }
        return instance;
    }

    public boolean checkUserLogin (String login, String pass){

        if(UserDAOService.getInstance().getUserByLoginPass(login, pass) != null)
        {
            return true;
        }
        else
            return false;
    }

    public boolean checkAdminLogin (String login, String pass){
        if(ADMIN_LOGIN.equals(login) && ADMIN_PASS.equals(pass)){
            return true;
        }
        return false;
    }

}
