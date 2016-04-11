package by.academy.it.belotserkovsky.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Kostya on 06.04.2016.
 */
public interface DAO <T>{

    public void create(T t) throws SQLException;

    public T read(Object key) throws SQLException;

    public void update(T t) throws SQLException;

    public void delete(Object key) throws SQLException;

    public List<T> readAll() throws SQLException;
}
