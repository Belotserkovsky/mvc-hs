package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import java.io.Serializable;

/**
 * General interface DAO
 * Created by Kostya on 06.04.2016.
 */
public interface DAO <T>{

    /**
     * @param t
     * @throws ExceptionDAO
     */
    void saveOrUpdate(T t) throws ExceptionDAO;

    /**
     * @param id
     * @return T
     * @throws ExceptionDAO
     */
    T get(Serializable id) throws ExceptionDAO;

    /**
     * @param id
     * @return T
     * @throws ExceptionDAO
     */
    T load(Serializable id) throws ExceptionDAO;

    /**
     * @param t
     * @throws ExceptionDAO
     */
    void delete(T t) throws ExceptionDAO;
}
