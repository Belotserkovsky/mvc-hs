package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.pojos.Worker;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 *
 */
public class WorkerServiceTest {
    private static String PARAM_NAME_PROF = "электрик";
    private Session session = null;
    private Transaction transaction = null;


    @Test
    public void getWorkersList(){
        List<Worker> all = WorkerService.getInstance().getWorkersList();
        assertNotNull(all);
        HibernateUtil.closeSession();
    }

    @Test
    public void getByProfession(){
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        Worker worker = WorkerService.getInstance().getByProfession(PARAM_NAME_PROF);
        assertNotNull(worker);
        transaction.rollback();
        HibernateUtil.closeSession();
    }
}