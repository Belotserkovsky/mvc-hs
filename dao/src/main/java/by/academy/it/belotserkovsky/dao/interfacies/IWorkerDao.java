package by.academy.it.belotserkovsky.dao.interfacies;

import by.academy.it.belotserkovsky.pojos.Worker;
import java.util.List;

/**
 * Created by K.Belotserkovsky
 */
public interface IWorkerDao extends Dao<Worker> {

    /**
     * @param profession
     * @return Worker
     */
    Worker getByProfession(String profession);

    /**
     * @return List<Worker>
     */
    List<Worker> getWorkers();
}
