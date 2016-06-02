package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.dao.interfacies.IWorkerDao;
import by.academy.it.belotserkovsky.pojos.Worker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by K.Belotserkovsky
 */

@ContextConfiguration("/testDao.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager")
@Transactional()
public class WorkerDaoTest {
    private String PARAM_NAME_PROF = "электрик";

    @Autowired
    IWorkerDao workerDao;

    @Before
    public void before(){
        Worker worker = new Worker();
        worker.setFullName("fullname");
        worker.setProfession(PARAM_NAME_PROF);
        workerDao.saveOrUpdate(worker);
    }

    @Test
    public void get() throws Exception {
        Worker worker = workerDao.getByProfession(PARAM_NAME_PROF);
        assertNotNull(worker);
    }

    @Test
    public void getAll() throws Exception{
        List<Worker> list = workerDao.getWorkers();
        assertNotNull(list);
    }

    @Test
    public void saveOrUpdate(){
        Worker worker = new Worker();
        worker.setFullName("fullname");
        worker.setProfession("profession2");
        workerDao.saveOrUpdate(worker);
    }
}