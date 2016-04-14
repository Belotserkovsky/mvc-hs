package by.academy.it.belotserkovsky.logic;

import by.academy.it.belotserkovsky.dao.UserDAO;
import by.academy.it.belotserkovsky.daoServices.UserDAOService;
import by.academy.it.belotserkovsky.entity.User;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * testing LoginLogic class methods
 * Created by Администратор on 14.04.2016.
 */
public class LoginLogicTest {
    private static Logger log = Logger.getLogger(LoginLogicTest.class);

    private static final String login = "login";
    private static final String pass = "password";
    private static final String adminLogin = "admin";
    private static final String adminPass = "admin";

    @Before
    public void beforeTest(){
        User user = new User ("name", "address", "phone", "email", "login", "password");
        try {
            UserDAO.getInstance().create(user);
        }catch (SQLException e){
            log.error("SQLException during creation test user: " + e);
        }
    }

    @Test
    public void checkUserLogin() throws Exception {

        boolean actual = LoginLogic.getInstance().checkUserLogin(login, pass);
        assertTrue(actual);

        actual = LoginLogic.getInstance().checkUserLogin("badLogin", "badPass");
        assertFalse(false);

    }

    @Test
    public void checkAdminLogin() throws Exception {

        boolean actual = LoginLogic.getInstance().checkAdminLogin(adminLogin, adminPass);
        assertTrue(actual);

        actual = LoginLogic.getInstance().checkAdminLogin("fff", adminPass);
        assertFalse(actual);

        actual = LoginLogic.getInstance().checkAdminLogin("fff", "pass");
        assertFalse(actual);
    }

    @After
    public void afterTest(){
            UserDAOService.getInstance().deleteUser(login);
    }

}