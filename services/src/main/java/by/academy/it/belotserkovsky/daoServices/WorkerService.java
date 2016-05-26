package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.interfacies.IWorkerDao;
import by.academy.it.belotserkovsky.pojos.Worker;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Access to the class object WorkerDao
 * Created by K.Belotserkovsky
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class WorkerService implements IWorkerService{
    private static Logger log = Logger.getLogger(UserService.class);

    @Autowired
    private IWorkerDao workerDAO;

    public List<Worker> getWorkers () {
        List<Worker> all = workerDAO.getWorkers();
        return all;
    }
}
