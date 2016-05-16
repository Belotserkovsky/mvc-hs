package by.academy.it.belotserkovsky.dao.interfacies;

import by.academy.it.belotserkovsky.exceptions.ExceptionDao;

import java.util.List;

/**
 * Created by K.Belotserkovsky
 */
public interface IUserDao<T> extends Dao<T>{

    T getByLoginPass(String login, String password) throws ExceptionDao;
}
