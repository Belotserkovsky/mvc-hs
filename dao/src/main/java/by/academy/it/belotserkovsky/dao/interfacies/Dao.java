package by.academy.it.belotserkovsky.dao.interfacies;

import by.academy.it.belotserkovsky.dto.UserDto;
import by.academy.it.belotserkovsky.exceptions.ExceptionDao;
import java.io.Serializable;
import java.util.List;

/**
 * General interface Dao
 * Created by K.Belotserkovsky
 */
public interface Dao<T>{

    /**
     * @param t
     * @throws ExceptionDao
     */
    void saveOrUpdate(T t) throws ExceptionDao;

    /**
     * @param id
     * @return T
     * @throws ExceptionDao
     */
    T get(Serializable id) throws ExceptionDao;

    /**
     * @param t
     * @throws ExceptionDao
     */
    void delete(T t) throws ExceptionDao;

}
