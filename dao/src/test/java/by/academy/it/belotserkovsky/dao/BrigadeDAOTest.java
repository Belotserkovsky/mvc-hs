package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.entity.Brigade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * testing BrigadDAO create() method
 * Created by Администратор on 13.04.2016.
 */
public class BrigadeDAOTest {

    private BrigadeDAO brigadeDAO;

    @Before
    @Test
    public void create() throws Exception {
        Brigade brigade = new Brigade();

        brigade.setName("brigade");

        brigadeDAO = BrigadeDAO.getInstance();
        brigadeDAO.create(brigade);

        List<Brigade> brigadesList = BrigadeDAO.getInstance().readAll();

        Assert.assertEquals(1, brigadesList.size());
        Assert.assertEquals(brigade.getName(), brigadesList.get(9).getName());

    }

}