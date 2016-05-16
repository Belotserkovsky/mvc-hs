package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.pojos.Worker;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by K.Belotserkovsky
 */
public class WorkerDaoTest {
    private String PARAM_NAME_PROF = "электрик";
    private WorkerDao wd = new WorkerDao();
    Session session = null;
    Transaction transaction = null;

    @Before
    public void before(){
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
    }

    @Test
    public void get() throws Exception {
        Worker w = wd.get(PARAM_NAME_PROF);
        assertNotNull(w);
    }

    @After
    public void after(){
        if(transaction != null){
            transaction.commit();
        }
        HibernateUtil.closeSession();
    }
}