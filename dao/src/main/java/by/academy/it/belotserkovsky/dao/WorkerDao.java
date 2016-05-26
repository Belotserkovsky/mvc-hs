package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.dao.interfacies.IWorkerDao;
import by.academy.it.belotserkovsky.pojos.Worker;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by K.Belotserkovsky
 */

@Repository
public class WorkerDao extends BaseDao<Worker> implements IWorkerDao {
    private static Logger log = Logger.getLogger(WorkerDao.class);

    @Autowired
    public WorkerDao(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    public Worker getByProfession(String profession) {
        String hql = "SELECT worker FROM Worker worker WHERE worker.profession=:profession";
        Query query = getSession().createQuery(hql);
        query.setParameter("profession", profession);
        Worker worker = (Worker)query.uniqueResult();
        log.info("Got worker by profession:" + worker);
        return worker;
    }

    public List<Worker> getWorkers(){
        String hql = "from Worker";
        Query query = getSession().createQuery(hql);
        log.info("Got list of workers.");
        return query.list();
    }
}
