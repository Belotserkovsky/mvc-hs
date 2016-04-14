package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.entity.Worker;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 *
 */
public class WorkerDAOTest {

    @Test
    public void readAll() throws Exception {

        Worker worker = new Worker();
        List<Worker> actual = WorkerDAO.getInstance().readAll();
        assertNotNull(actual);
        assertNotEquals(actual, worker);

    }

}