package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import by.academy.it.belotserkovsky.pojos.Worker;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Kostya on 24.04.2016.
 */
public class WorkerDAO extends BaseDAO<Worker> {
    private static Logger log = Logger.getLogger(WorkerDAO.class);

    /**
     * @param profession
     * @return
     * @throws ExceptionDAO
     */
    public Worker get(String profession) throws ExceptionDAO{
        Worker worker = null;
            try{
                Session session = HibernateUtil.getSession();
                String hql = "SELECT worker FROM Worker worker WHERE worker.profession=:profession";
                Query query = session.createQuery(hql);
                query.setParameter("profession", profession);
                worker = (Worker)query.uniqueResult();
            }catch (HibernateException e){
                log.error("Error get worker by profession in DAO: " + e);
                throw new ExceptionDAO(e);
            }
        return worker;
    }
}
