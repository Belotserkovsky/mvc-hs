package by.academy.it.belotserkovsky.services;

import by.academy.it.belotserkovsky.pojos.Worker;

import java.util.List;

/**
 * Created by K.Belotserkovsky
 */
public interface IWorkerService {

    /**
     * @return List<Worker>
     */
    List<Worker> getWorkers();
}
