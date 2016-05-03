package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.UserDAO;
import by.academy.it.belotserkovsky.dto.UserDTO;
import by.academy.it.belotserkovsky.pojos.Bid;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.pojos.UserContacts;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
    private static Logger log = Logger.getLogger(BidDAOServiceTest.class);
    private static String LOGIN = "login";
    private static String PASSWORD = "password";
    private static String KIND_OF_WORK = "kind of work";
    private static String SCOPE = "scope";
    private static String DESIRED_RUNTIME = "desired_runtime";
    UserDAOService uds = null;
    BidDAOService bds = null;
    Bid bid = null;
    Transaction transaction = null;

    @Before
    public void before(){
        uds = UserDAOService.getInstance();
        bds = BidDAOService.getInstance();
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("test");
        userDTO.setSecondName("test");
        userDTO.setLogin("login");
        userDTO.setPassword("password");
        userDTO.setEmail("email");
        userDTO.setAddress("address");
        userDTO.setPhone("phone");

        uds.createOrUpdate(userDTO);

    }

    @Test
    public void createOrUpdate() throws Exception {
        Session session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        Bid bid = new Bid();
        bid.setKindOfWorks(KIND_OF_WORK);
        bid.setDesiredRuntime(DESIRED_RUNTIME);
        bid.setScope(SCOPE);

        User user = UserDAOService.getInstance().getById(Long.parseLong("1"));
        bid.setUser(user);

        Set<Bid> bids = new HashSet<Bid>();
        bids.add(bid);
        user.setBids(bids);

        UserDAO userDAO = new UserDAO();
        userDAO.saveOrUpdate(user);
        transaction.commit();

    }
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
    @After
    public void after(){
        uds = null;
        bds = null;
        bid = null;
    }
}