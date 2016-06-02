package by.academy.it.belotserkovsky.services;

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

@ContextConfiguration("/testServices.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager")
@Transactional()
public class WorkerServiceTest {
    private static String PARAM_NAME_PROF = "электрик";

    @Autowired
    IWorkerService workerService;

    @Autowired
    IWorkerDao workerDao;

    @Before
    public void before(){
        Worker worker = new Worker();
        worker.setFullName("Vasya Pupkin");
        worker.setProfession(PARAM_NAME_PROF);
        workerDao.saveOrUpdate(worker);
    }

    @Test
    public void getWorkersList(){
        List<Worker> list = workerService.getWorkers();
        assertNotNull(list);
    }

}