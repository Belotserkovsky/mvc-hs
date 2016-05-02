package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.UserContactsDAO;
import by.academy.it.belotserkovsky.dto.UserDTO;
import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.pojos.UserContacts;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
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
    private UserDTO userDTO = null;
    private UserContacts contacts = null;


//    @Test
//    public void getInstance() throws Exception {
//        UserDAOService testService = UserDAOService.getInstance();
//        assertNotNull(testService);
//    }

    @Test
    public void createOrUpdate() throws Exception {
        uds = UserDAOService.getInstance();
        userDTO = new UserDTO("testname", "testttt", "login", "password", "test_email", "test_address", "test_phone");
        uds.createOrUpdate(userDTO);

//        userDTO = uds.getUserByLoginPass(login, pass);
//
//        uds.deleteUser(userDTO);
    }

//    @Test
//    public void getUserByLoginPass() throws Exception {
//        uds = UserDAOService.getInstance();
//        user = new UserDTO("testname", "testttt", "login", "password", "test_email", "test", "test");
//        uds.createOrUpdate(user);
//        user = uds.getUserByLoginPass(login, pass);
//        assertEquals(login, user.getLogin());
//        assertEquals(pass, user.getPassword());
//        assertNotNull(user);
//        log.info("Reading: " + user);
//    }


    @After
    public void after(){
        uds = null;
        userDTO = null;
        contacts = null;
    }

}