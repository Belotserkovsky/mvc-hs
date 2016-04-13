package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.entity.Bid;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * testing BidDAO  methods
 * Created by Администратор on 13.04.2016.
 */
public class BidDAOTest {

    private BidDAO bidDAO;

    @Before
    @Test
    public void create() throws Exception {
        Bid bid = new Bid();

        bid.setKindOfWorks("kind of works");
        bid.setScope("scope");
        bid.setDesiredRuntime("desired runtime");
        bidDAO = BidDAO.getInstance();
        bidDAO.create(bid);

        List<Bid> bidList = BidDAO.getInstance().readAll();

        Assert.assertEquals(1, bidList.size());
        Assert.assertEquals(bid.getDesiredRuntime(), bidList.get(0).getDesiredRuntime());

    }

    @Test
    public void read() throws Exception {

    }

    @Test
    public void readAll() throws Exception {

    }

    @Test
    public void isUpdate() throws Exception {

    }

    @Test
    public void isDelete() throws Exception {

    }

}