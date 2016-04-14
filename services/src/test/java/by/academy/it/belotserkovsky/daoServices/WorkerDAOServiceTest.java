package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.entity.Worker;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 *
 */
public class WorkerDAOServiceTest {

    @Test
    public void getWorkersList() throws Exception {
        List<Worker> actual = WorkerDAOService.getInstance().getWorkersList();

        assertNotNull(actual);
        assertNotEquals(actual, null);

    }

}