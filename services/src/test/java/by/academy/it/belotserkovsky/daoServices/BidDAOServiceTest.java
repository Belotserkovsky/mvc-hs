package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.pojos.Bid;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.pojos.UserContacts;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Kostya on 27.04.2016.
 */
public class BidDAOServiceTest {
//    private static Logger log = Logger.getLogger(BidDAOServiceTest.class);
//    private static String LOGIN = "login";
//    private static String PASSWORD = "password";
//    private static String KIND_OF_WORK = "kind of work";
//    private static String SCOPE = "scope";
//    private static String DESIRED_RUNTIME = "desired_runtime";
//    UserDAOService uds = null;
//    BidDAOService bds = null;
//    UContactsDAOService ucds = UContactsDAOService.getInstance();
//    User user = null;
//    UserContacts contacts = null;
//    Bid bid = null;
//
//    @Before
//    public void before(){
//        uds = UserDAOService.getInstance();
//        bds = BidDAOService.getInstance();
//        user = new User();
//        contacts = new UserContacts();
//        user.setFirstName("test");
//        user.setSecondName("test");
//        user.setLogin("login");
//        user.setPassword("password");
//        contacts.setEmail("email");
//        contacts.setAddress("address");
//        contacts.setPhone("phone");
//
//        uds.createOrUpdate(user);
//
//        //user = uds.getUserByLoginPass(LOGIN, PASSWORD);
//        user.setUserContacts(contacts);
//        contacts.setUser(user);
//
//        uds.createOrUpdate(user);
//        //ucds.createOrUpdate(contacts);
//
//
//    }
//
////    @Test
////    public void createOrUpdate() throws Exception {
////        Bid bid = new Bid();
////        bid.setKindOfWorks(KIND_OF_WORK);
////        bid.setDesiredRuntime(DESIRED_RUNTIME);
////        bid.setScope(SCOPE);
////        bid.setUser(user);
////
////        bds.createOrUpdate(bid);
////
////        Set<Bid> bids = new HashSet<Bid>();
////        bids.add(bid);
////        user.setBids(bids);
////
////        uds.createOrUpdate(user);
////
////        assertNotNull(bid.getId());
////
////    }
//
////    @Test
////    public void getBid() throws Exception {
////
////    }
////
////    @Test
////    public void deleteBid() throws Exception {
////
////    }
//
//    @After
//    public void after(){
//        uds = null;
//        bds = null;
//        ucds = null;
//        user = null;
//        contacts = null;
//        bid = null;
//    }
}