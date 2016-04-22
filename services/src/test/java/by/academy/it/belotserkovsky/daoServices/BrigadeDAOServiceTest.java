package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.pojos.Brigade;
import org.junit.Test;

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