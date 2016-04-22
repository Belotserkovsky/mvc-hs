package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.entity.Bid;
import by.academy.it.belotserkovsky.poolConnection.DataSource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * testing BiDAO class methods
 *
 */
public class BidDAOTest {
    private BidDAO bidDAO;

    @Test
    public void readAll() throws Exception {

        List<Bid> actual = new ArrayList<Bid>();
        actual = BidDAO.getInstance().readAll();
        assertNotEquals(actual, null);

        assertNotNull(actual);

    }

    @Test
    public void create() throws Exception {
        Bid bid = new Bid();

        bid.setKindOfWorks("kind of works");
        bid.setScope("scope");
        bid.setDesiredRuntime("desired runtime");
        bid.setUserId(1);
        bid.setBrigadeId(1);
        bidDAO = BidDAO.getInstance();
        bidDAO.create(bid);

        List<Bid> bidList = BidDAO.getInstance().readAll();

        //Assert.assertEquals(1, bidList.size());
        Assert.assertEquals(bid.getDesiredRuntime(), bidList.get(0).getDesiredRuntime());

    }

    @After
    public void deleteAll() throws Exception{
        Connection connection = null;
        Statement statement = null;
        String query = "TRUNCATE TABLE bids";

        connection = DataSource.getInstance().getConnection();
        statement = connection.createStatement();

        statement.execute(query);

        statement.close();
        connection.close();
    }
}