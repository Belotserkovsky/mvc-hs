package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.entity.Worker;
import by.academy.it.belotserkovsky.poolConnection.DataSource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import static org.junit.Assert.*;

/**
 * testing WorkerDAO methods
 * Created by Администратор on 13.04.2016.
 */
public class WorkerDAOTest {

    private  WorkerDAO workerDAO;

    @Test
    public void create() throws Exception {
        Worker worker = new Worker();

        worker.setFullName ("First name, second name");
        worker.setProfession ("profession");
        worker.setBrigadeId (100);

        workerDAO = WorkerDAO.getInstance();
        workerDAO.create(worker);

        List<Worker> workerList = workerDAO.readAll();

        Assert.assertEquals(1, workerList.size());
        Assert.assertEquals(worker.getFullName(), workerList.get(0).getFullName());
    }

    @After
    public void deleteAll() throws Exception{
        Connection connection = null;
        Statement statement = null;
        String query = "DELETE * FROM workers";

        connection = DataSource.getInstance().getConnection();
        statement = connection.createStatement();

        statement.execute(query);

        statement.close();
        connection.close();
    }
}