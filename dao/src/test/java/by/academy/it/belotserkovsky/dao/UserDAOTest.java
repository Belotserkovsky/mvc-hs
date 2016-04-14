package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.entity.User;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 */
public class UserDAOTest {
    private static Logger log = Logger.getLogger(UserDAOTest.class);
    private static final String login = "login";
    private static final String pass = "password";

    @Before
    public void before (){
        User user = new User ("name", "address", "phone", "email", "login", "password");
        try {
            UserDAO.getInstance().create(user);
        }catch (SQLException e){
            log.error("SQLException during creation test user: " + e);
        }
    }

    @Test
    public void read() throws Exception {

        User actual = UserDAO.getInstance().read(login, pass);
        assertEquals(login, actual.getLogin());
        assertEquals(pass, actual.getPassword());
        assertNotNull(actual);
    }

    @Test
    public void readAll() throws Exception {
        User user = new User();
        List<User> actual = UserDAO.getInstance().readAll();
        assertNotNull(actual);
        assertNotEquals(actual, user);
    }

    @After
    public static void after(){
        try {
        if(UserDAO.getInstance().isDelete(login)){
            log.info("Test user was delete: " + login);
        }
        }catch (SQLException e){
            log.error("SQLException during creation test user: " + e);
        }
    }
}