package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.entity.Brigade;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * testing BrigadeDAOService class methods
 */
public class BrigadeDAOServiceTest {

    @Test
    public void getBrigadesList() throws Exception {

        List<Brigade> actual = BrigadeDAOService.getInstance().getBrigadesList();
        assertNotNull(actual);
    }

}