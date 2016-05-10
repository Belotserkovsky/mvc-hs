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

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Администратор on 26.04.2016.
 */
public class UserDAOServiceTest {
//
//    private static Logger log = Logger.getLogger(UserDAOServiceTest.class);
//    private static final String login = "login";
//    private static final String pass = "password";
//    private UserDAOService uds = null;
//    private UserDTO userDTO = null;
//    private UserContacts contacts = null;
//
//
    @Test
    public void getByLoginPass() throws Exception {
        UserDTO user = UserDAOService.getInstance().getUserByLoginPass("login", "password");
        assertNotNull(user);
    }

//    @Test
//    public void createOrUpdate(){
//        Long uid = Long.parseLong("1");
//        UserDTO uDTO = new UserDTO(uid, "newname", "newname", "login", "password", "newaddress", "123456789", "newemail");
//        UserDAOService.getInstance().createOrUpdate(uDTO);
//    }
//
//    @Test
//    public void createOrUpdate() throws Exception {
//        uds = UserDAOService.getInstance();
//        userDTO = new UserDTO("testname", "testttt", "login", "password", "test_email", "test_address", "test_phone");
//        uds.createOrUpdate(userDTO);
//
////        userDTO = uds.getUserByLoginPass(login, pass);
////
////        uds.deleteUser(userDTO);
//    }
//
////    @Test
////    public void getUserByLoginPass() throws Exception {
////        uds = UserDAOService.getInstance();
////        user = new UserDTO("testname", "testttt", "login", "password", "test_email", "test", "test");
////        uds.createOrUpdate(user);
////        user = uds.getUserByLoginPass(login, pass);
////        assertEquals(login, user.getLogin());
////        assertEquals(pass, user.getPassword());
////        assertNotNull(user);
////        log.info("Reading: " + user);
////    }
//
//
//    @After
//    public void after(){
//        uds = null;
//        userDTO = null;
//        contacts = null;
//    }

//    @Test
//    public void getAll(){
//        UserDAOService uds = UserDAOService.getInstance();
//        List<UserDTO> result = uds.getAllUsers(1, 3);
//
//        assertNotNull(result);
//    }
}