package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.WorkerDAO;
import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import by.academy.it.belotserkovsky.pojos.Worker;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Access to the class object WorkerDAO
 * Created by K.Belotserkovsky
 */
public class WorkerService {
    private static Logger log = Logger.getLogger(UserService.class);
    private WorkerDAO workerDAO;
    private static WorkerService instance;
    private Transaction transaction = null;
    private Session session = null;

    public static synchronized WorkerService getInstance() {
        if (instance == null) {
            instance = new WorkerService();
        }
        return instance;
    }

    public WorkerService() {
        workerDAO = new WorkerDAO();
    }

    /**
     * @param worker
     */
    public void createOrUpdate(Worker worker) {
        try {
            if(worker != null) {
                workerDAO.saveOrUpdate(worker);
            }
        }catch (ExceptionDAO e){
            HibernateUtil.getSession().getTransaction().rollback();
            log.error("DAO exception in service layer during createOrUpdate() worker: " + e);
            HibernateUtil.closeSession();
        }
    }

    /**
     * @param profession
     * @return Worker
     */
    public Worker getByProfession(String profession){
        Worker worker = null;
        try{
            if(profession.length() > 0){
                worker = workerDAO.get(profession.toLowerCase().trim());
            }
        }catch (ExceptionDAO e){
            HibernateUtil.getSession().getTransaction().rollback();
            log.error("DAO exception in service layer during getByProfession() worker: " + e);
            HibernateUtil.closeSession();
        }
        return worker;
    }

    /**
     * @return List<Worker>
     */
    public List<Worker> getWorkersList () {
        List<Worker> all = null;
        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            all = (List<Worker>)workerDAO.getAll();
        } catch (ExceptionDAO e) {
            if(transaction != null){
                transaction.rollback();
            }
           log.error("DAO exception in service layer during getAll() workers: " + e);
            HibernateUtil.closeSession();
        }
        return all;
    }
}
