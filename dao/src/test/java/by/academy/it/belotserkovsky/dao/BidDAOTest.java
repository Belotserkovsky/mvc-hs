package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.entity.Bid;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * testing BiDAO class methods
 *
 */
public class BidDAOTest {
    @Test
    public void readAll() throws Exception {

        List<Bid> actual = new ArrayList<Bid>();
        actual = BidDAO.getInstance().readAll();
        assertNotEquals(actual, null);

        assertNotNull(actual);

    }

}