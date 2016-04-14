package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.entity.Bid;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import static org.junit.Assert.*;

/**
 * testing BidDAOService class methods
 * Created by Администратор on 14.04.2016.
 */
public class BidDAOServiceTest {

    @Test
    public void getBidByUserID() throws Exception {
        Integer key = new Integer(1);

        Bid actual = new Bid();

        actual = BidDAOService.getInstance().getBidByUserID(key);
        assertNotNull(actual);

    }

    @Test
    public void getBidsList() throws Exception {

        List<Bid> actual = new ArrayList<Bid>();
        actual = BidDAOService.getInstance().getBidsList();
        assertNotEquals(actual, null);

    }



}