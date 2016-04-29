package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.UserContactsDAO;
import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.pojos.UserContacts;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Администратор on 26.04.2016.
 */
public class UserDAOServiceTest {

    private static Logger log = Logger.getLogger(UserDAOServiceTest.class);
    private static final String login = "login";
    private static final String pass = "password";
    private UserDAOService uds = null;
    private User user = null;
    private UserContacts contacts = null;

    @Before
    public void before(){
        uds = UserDAOService.getInstance();
        user = new User();
        contacts = new UserContacts();
        user.setFirstName("test");
        user.setSecondName("test");
        user.setLogin("login");
        user.setPassword("password");
        contacts.setEmail("email");
        contacts.setAddress("address");
        contacts.setPhone("phone");

        //uds.createOrUpdate(user);

        //user = uds.getUserByLoginPass(login, pass);
        user.setUserContacts(contacts);
        contacts.setUser(user);

        uds.createOrUpdate(user);

//        UserContactsDAO userContactsDAO = new UserContactsDAO();
//        try {
//            userContactsDAO.saveOrUpdate(contacts);
//        }catch (ExceptionDAO e){
//            log.error("ExceptionDAO during creation saveOrUpdate() contacts: " + e);
//        }
    }

//    @Test
//    public void getInstance() throws Exception {
//        UserDAOService testService = UserDAOService.getInstance();
//        assertNotNull(testService);
//    }
//
    @Test
    public void createOrUpdate() throws Exception {
        assertNotNull(user);
    }

//    @Test
//    public void getUserByLoginPass() throws Exception {
//        assertEquals(login, user.getLogin());
//        assertEquals(pass, user.getPassword());
//        assertNotNull(user);
//        log.info("Reading: " + user);
//    }

//    @Test
//    public void deleteUser(){
//        uds.deleteUser(user);
//    }
//    @Test
//    public void createOrUpdate(){
//        uds = UserDAOService.getInstance();
//        user = new User();
//        user.setFirstName("test");
//        user.setSecondName("test");
//        user.setLogin("login");
//        user.setPassword("password");
//        uds.createOrUpdate(user);
//    }


    @After
    public void after(){
        uds = null;
        user = null;
        contacts = null;
    }

}