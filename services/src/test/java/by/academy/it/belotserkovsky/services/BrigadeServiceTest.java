package by.academy.it.belotserkovsky.services;

import by.academy.it.belotserkovsky.dao.interfacies.IBidDao;
import by.academy.it.belotserkovsky.dao.interfacies.IWorkerDao;
import by.academy.it.belotserkovsky.dto.BidDto;
import by.academy.it.belotserkovsky.pojos.Bid;
import by.academy.it.belotserkovsky.pojos.Worker;
import by.academy.it.belotserkovsky.pojos.constants.Status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by K.Belotserkovsky
 */

@ContextConfiguration("/testServices.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager")
@Transactional()
public class BrigadeServiceTest {
    private static String KIND_OF_WORK = "электротехнические";
    private static String SCOPE = "scope";
    private static String DESIRED_RUNTIME = "desired_runtime";
    private Long bidId;

    @Autowired
    IBidDao bidDao;

    @Autowired
    IBrigadeService brigadeService;

    @Autowired
    IWorkerDao workerDao;

    @Before
    public void before(){
        Worker worker = new Worker();
        worker.setFullName("Vasya Pupkin");
        worker.setProfession("электрик");
        workerDao.saveOrUpdate(worker);

        Date currentDate = new Date(System.currentTimeMillis());
        String status = Status.OPEN.getType();
        Bid bid = new Bid("kind of work", SCOPE, DESIRED_RUNTIME, currentDate, status);
        bidId = bidDao.saveOrUpdate(bid).getId();
    }

    @Test
    public void createBrigade() throws Exception {
        String[] selected = {KIND_OF_WORK};
        brigadeService.createBrigade(selected, bidId);
    }

    @Test
    public void defineProfession(){
        assertNotNull(brigadeService.defineProfession(KIND_OF_WORK));
    }
}