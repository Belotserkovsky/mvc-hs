package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.WorkerDAO;
import by.academy.it.belotserkovsky.entity.Worker;

import java.sql.SQLException;
import java.util.List;

/**
 * Access to the class object WorkerDAO
 * Created by Kostya on 08.04.2016.
 */
public class WorkerDAOService {
    private static WorkerDAOService instance;

    public static WorkerDAOService getInstance() {
        if (instance == null) {
            instance = new WorkerDAOService();
        }
        return instance;
    }

    private WorkerDAO workerDAO;

    public void addWorker(Worker worker) {
        try {
            workerDAO.create(worker);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateWorker (Worker worker) {
        try{
            workerDAO.update(worker);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteWorker (Object profession) {
        try {
            workerDAO.delete(profession);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Worker> getWorkersList () {
        try {
            return workerDAO.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
