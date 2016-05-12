package by.academy.it.belotserkovsky.logic;

import by.academy.it.belotserkovsky.dao.UserDAO;
import by.academy.it.belotserkovsky.daoServices.UserDAOService;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * testing LoginLogic class methods
 * Created by K.Belotserkovsky
 */
public class LoginLogicTest {
    private static Logger log = Logger.getLogger(LoginLogicTest.class);

    private static final String login = "login";
    private static final String pass = "password";
    private static final String adminLogin = "admin";
    private static final String adminPass = "admin";
    Session session = null;
    Transaction transaction = null;


    @Test
    public void checkUserLogin() throws Exception {
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();

        boolean actual = LoginLogic.getInstance().checkUserLogin(login, pass);
        assertTrue(actual);

        if(transaction != null){
            transaction.commit();
        }
        HibernateUtil.closeSession();
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


}