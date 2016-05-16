package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dto.BidDto;
import by.academy.it.belotserkovsky.pojos.Bid;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Kostya on 27.04.2016.
 */
public class BidServiceTest {
    private static Logger log = Logger.getLogger(BidServiceTest.class);
    private static String LOGIN = "login";
    private static String PASSWORD = "password";
    private static String KIND_OF_WORK = "kind of work";
    private static String SCOPE = "scope";
    private static String DESIRED_RUNTIME = "desired_runtime";
    UserService uds = null;
    BidService bds = null;
    Bid bid = null;
    Session session = null;
    Transaction transaction = null;

    @Test
    public void createBid() throws Exception {

        User user = UserService.getInstance().getById(Long.parseLong("1"));
        BidDto bDTO = new BidDto(Long.parseLong("1"), "ggggggg", "rrrrrrr", "ttttttt");

        Set<Bid> bids = new HashSet<Bid>();
        bids.add(bid);
        user.setBids(bids);
        BidService.getInstance().createBid(bDTO);

        if(transaction != null){
            transaction.commit();
        }
        HibernateUtil.closeSession();
    }

    @Test
    public void getAll() {
        List<BidDto> list = BidService.getInstance().getBidsList();
        assertNotNull(list);

        if(transaction != null){
            transaction.commit();
        }
        HibernateUtil.closeSession();
    }

    @Test
    public void createOrUpdate(){
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();

        Bid bid = new Bid("род работ", "масштаб", "время выполнеиня");
        User user = UserService.getInstance().getById(Long.parseLong("1"));
        bid.setUser(user);
        BidService.getInstance().createOrUpdate(bid);

        if(transaction != null){
            transaction.commit();
        }
        HibernateUtil.closeSession();
    }

}