package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.dao.interfacies.IBidDao;
import by.academy.it.belotserkovsky.dto.BidDto;
import by.academy.it.belotserkovsky.pojos.Bid;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by K.Belotserkovsky
 */

@ContextConfiguration("/testDao.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager")
@Transactional()
public class BidDaoTest {
    private Long id;

    @Autowired
    IBidDao bidDao;

    @Before
    public void before() {
        Bid bid = new Bid("kindOfWorks", "scope", "desiredRintime", new Date(System.currentTimeMillis()), "status");
        id = bidDao.saveOrUpdate(bid).getId();
    }

    @Test
    public void saveOrUpdate(){
        Bid bid = new Bid("kindOfWorks", "scope", "desiredRintime", new Date(System.currentTimeMillis()), "status");
        assertNotNull(bidDao.saveOrUpdate(bid));
    }

    @Test
    public void getBtId(){
        Bid bid = bidDao.get(id);
    }

    @Test
    public void getAll() throws Exception {
        List<BidDto> list = bidDao.getAll();
        assertNotNull(list);
    }

}