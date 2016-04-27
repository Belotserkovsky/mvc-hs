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
    UserDAOService uds = null;
    User user = null;
    UserContacts contacts = null;
    Long uid = null;

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

        uds.addOrUpdate(user);

        user = uds.getUserByLoginPass(login, pass);
        //uid = user.getId();
        //contacts.setId(uid);
        contacts.setUser(user);
        user.setUserContacts(contacts);

        uds.addOrUpdate(user);

        UserContactsDAO userContactsDAO = new UserContactsDAO();
        try {
            userContactsDAO.saveOrUpdate(contacts);
        }catch (ExceptionDAO e){
            log.error("ExceptionDAO during creation saveOrUpdate() contacts: " + e);
        }
    }

//    @Test
//    public void getInstance() throws Exception {
//        UserDAOService testService = UserDAOService.getInstance();
//        assertNotNull(testService);
//    }
//
//    @Test
//    public void addOrUpdate() throws Exception {
//        try{
//            user = userDAO.get(login, pass);
//            contacts.setId(user.getId());
//            user.setUserContacts(contacts);
//
//            UserDAOService.getInstance().addOrUpdate(user);
//
//        }catch (ExceptionDAO e){
//            log.error("ExceptionDAO during creation UserDAOServiceTest(): " + e);
//        }
//    }

    @Test
    public void getUserByLoginPass() throws Exception {
        assertEquals(login, user.getLogin());
        assertEquals(pass, user.getPassword());
        assertNotNull(user);
    }

//    @Test
//    public void updateContacts()throws Exception{
//        contacts.setUser(user);
//        user.setUserContacts(contacts);
//
//        uds.updateContacts(uid, contacts);
//
//    }

    @After
    public void after(){
        uds = null;
        user = null;
        contacts = null;
    }

}