package by.academy.it.belotserkovsky.logic;

import by.academy.it.belotserkovsky.daoServices.UserService;

/**
 * for user authentication logic
 * Created by Kostya on 09.04.2016.
 */
public class LoginLogic {
    private static LoginLogic instance;

    private final static String ADMIN_LOGIN = "admin";
    private final static String ADMIN_PASS = "admin";

    private LoginLogic() {
        super();
    }

    /**
     * @return Singleton
     */
    public static LoginLogic getInstance() {
        if (instance == null) {
            instance = new LoginLogic();
        }
        return instance;
    }

    /**
     * @param login
     * @param pass
     * @return boolean
     */
    public boolean checkUserLogin (String login, String pass){

        if(UserService.getInstance().getUserByLoginPass(login, pass) != null)
        {
            return true;
        }
        else
            return false;
    }

    /**
     * @param login
     * @param pass
     * @return boolean
     */
    public boolean checkAdminLogin (String login, String pass){
        if(ADMIN_LOGIN.equals(login) && ADMIN_PASS.equals(pass)){
            return true;
        }
        return false;
    }

}
