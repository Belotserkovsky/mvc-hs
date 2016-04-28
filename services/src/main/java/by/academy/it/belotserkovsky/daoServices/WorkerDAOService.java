package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.WorkerDAO;
import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import by.academy.it.belotserkovsky.pojos.Worker;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

/**
 * Access to the class object WorkerDAO
 * Created by Kostya on 08.04.2016.
 */
public class WorkerDAOService {
    private static Logger log = Logger.getLogger(UserDAOService.class);
    private WorkerDAO workerDAO;
    private static WorkerDAOService instance;

    public static synchronized WorkerDAOService getInstance() {
        if (instance == null) {
            instance = new WorkerDAOService();
        }
        return instance;
    }

    public WorkerDAOService() {
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
            log.error("DAO exception in service layer during createOrUpdate() worker: " + e);
        }
    }

    /**
     * @param worker
     */
    public void delete (Worker worker) {
        try {
            if(worker != null) {
                workerDAO.delete(worker);
            }
        } catch (ExceptionDAO e){
            log.error("DAO exception in service layer during delete() worker: " + e);
        }
    }
//
//    public List<Worker> getWorkersList () {
//        try {
//            return workerDAO.readAll();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
