package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.entity.Brigade;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 *
 */
public class BrigadeDAOTest {
    @Test
    public void readAll() throws Exception {

        List<Brigade> actual = BrigadeDAO.getInstance().readAll();
        assertNotNull(actual);
        assertNull(actual);
    }

}