package by.academy.it.belotserkovsky.dao.interfacies;

import by.academy.it.belotserkovsky.exceptions.ExceptionDao;

import java.util.List;

/**
 * Created by K.Belotserkovsky
 */
public interface IWorkerDao<T> extends Dao<T> {

    List<T> getWorkers() throws ExceptionDao;
}
