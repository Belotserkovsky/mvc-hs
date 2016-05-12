package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * General interface DAO
 * Created by Kostya on 06.04.2016.
 */
public interface DAO <T>{

    void saveOrUpdate(T t) throws ExceptionDAO;

    T get(Serializable id) throws ExceptionDAO;

    T load(Serializable id) throws ExceptionDAO;

    void delete(T t) throws ExceptionDAO;
}
