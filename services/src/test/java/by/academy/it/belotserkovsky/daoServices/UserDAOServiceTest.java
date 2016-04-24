package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.UserDAO;
import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import by.academy.it.belotserkovsky.pojos.User;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 *
 *
 */
public class UserDAOServiceTest {
    private static Logger log = Logger.getLogger(UserDAOServiceTest.class);
    private static final String login = "login";
    private static final String pass = "password";
    UserDAO userDAO = null;

   @Before
   public void before(){
       User user = new User();
       user.setFirstName("test");
       user.setSecondName("test");
       user.setLogin("login");
       user.setPassword("password");

       try {
           userDAO = new UserDAO();
           userDAO.saveOrUpdate(user);
       }catch (ExceptionDAO e){
           log.error("SQLException during creation test user: " + e);
       }
   }

    @Test
    public void getUserByLoginPass() throws Exception {
        User actual = UserDAOService.getInstance().getUserByLoginPass(login, pass);
        assertEquals(login, actual.getLogin());
        assertEquals(pass, actual.getPassword());
        assertNotNull(actual);
    }

    @After
    public void after(){
        userDAO = null;
    }
}