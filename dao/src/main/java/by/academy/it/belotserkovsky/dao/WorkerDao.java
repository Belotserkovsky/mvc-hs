package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.dao.interfacies.IWorkerDao;
import by.academy.it.belotserkovsky.exceptions.ExceptionDao;
import by.academy.it.belotserkovsky.pojos.Worker;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Kostya on 24.04.2016.
 */
public class WorkerDao extends BaseDao<Worker> implements IWorkerDao<Worker> {
    private static Logger log = Logger.getLogger(WorkerDao.class);

    /**
     * @param profession
     * @return
     * @throws ExceptionDao
     */
    public Worker get(String profession) throws ExceptionDao {
        Worker worker = null;
            try{
                Session session = HibernateUtil.getSession();
                String hql = "SELECT worker FROM Worker worker WHERE worker.profession=:profession";
                Query query = session.createQuery(hql);
                query.setParameter("profession", profession);
                worker = (Worker)query.uniqueResult();
            }catch (HibernateException e){
                log.error("Error get worker by profession in Dao: " + e);
                throw new ExceptionDao(e);
            }
        return worker;
    }

    public List<Worker> getWorkers(){
        Session session = HibernateUtil.getSession();
        String hql = "from Worker";
        Query query = session.createQuery(hql);
        return query.list();
    }
}
