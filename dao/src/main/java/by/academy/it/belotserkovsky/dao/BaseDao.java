package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.dao.interfacies.Dao;
import by.academy.it.belotserkovsky.exceptions.ExceptionDao;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Parent class Dao
 * Created by Kostya on 22.04.2016.
 * @param <T>
 */
public class BaseDao<T> implements Dao<T> {
    private static Logger log = Logger.getLogger(BaseDao.class);
    private Session session = null;

    public void saveOrUpdate(T t) throws ExceptionDao {
        session = HibernateUtil.getSession();
        session.saveOrUpdate(t);
        log.info("saveOrUpdate(t):" + t);
    }

    public T get(Serializable id) throws ExceptionDao {
        log.info("Get class by id:" + id);
        T t = null;
        try {
            session = HibernateUtil.getSession();
            t = (T) session.get(getPersistentClass(), id);
            log.info("get class:" + t);
        } catch (HibernateException e) {
            log.error("Error get " + getPersistentClass() + " in Dao" + e);
            throw new ExceptionDao(e);
        }
        return t;
    }

    public void delete(T t) throws ExceptionDao {
        try {
            session = HibernateUtil.getSession();
            session.delete(t);
            log.info("Delete:" + t);
        } catch (HibernateException e) {
            log.error("Error delete in Dao" + e);
            throw new ExceptionDao(e);
        }
    }

    private Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
