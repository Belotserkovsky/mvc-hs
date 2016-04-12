package by.academy.it.belotserkovsky.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Kostya on 06.04.2016.
 */
public interface DAO <T>{

    public void create(T t) throws SQLException;

    public T read(Object key) throws SQLException;

    public boolean isUpdate(T t) throws SQLException;

    public boolean isDelete(Object key) throws SQLException;

    public List<T> readAll() throws SQLException;
}
