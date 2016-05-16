package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.dto.BidDto;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by K.Belotserkovsky
 */
public class BidDaoTest {
    Session session = null;
    Transaction transaction = null;
    private BidDao bd = new BidDao();

    @Before
    public void before() {
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
    }

    @Test
    public void getAll() throws Exception {
        List<BidDto> list = bd.getAll();
        assertNotNull(list);
    }

    @After
    public void after(){
        if(transaction != null){
            transaction.commit();
        }
        HibernateUtil.closeSession();
    }
}