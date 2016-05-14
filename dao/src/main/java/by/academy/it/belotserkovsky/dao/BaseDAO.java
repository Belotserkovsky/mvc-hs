package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Parent class DAO
 * Created by Kostya on 22.04.2016.
 * @param <T>
 */
public class BaseDAO<T> implements DAO<T>{
    private static Logger log = Logger.getLogger(BaseDAO.class);
    private Session session = null;

    public void saveOrUpdate(T t) throws ExceptionDAO{
        session = HibernateUtil.getSession();
        session.saveOrUpdate(t);
        log.info("saveOrUpdate(t):" + t);
    }

    public T get(Serializable id) throws ExceptionDAO {
        log.info("Get class by id:" + id);
        T t = null;
        try {
            session = HibernateUtil.getSession();
            t = (T) session.get(getPersistentClass(), id);
            log.info("get class:" + t);
        } catch (HibernateException e) {
            log.error("Error get " + getPersistentClass() + " in Dao" + e);
            throw new ExceptionDAO(e);
        }
        return t;
    }

    public T load(Serializable id) throws ExceptionDAO {
        log.info("Load class by id:" + id);
        T t = null;
        try {
            session = HibernateUtil.getSession();
            t = (T) session.load(getPersistentClass(), id);
            log.info("load() clazz:" + t);
            session.isDirty();
        } catch (HibernateException e) {
            log.error("Error load() " + getPersistentClass() + " in Dao" + e);
            throw new ExceptionDAO(e);
        }
        return t;
    }

    public void delete(T t) throws ExceptionDAO {
        try {
            session = HibernateUtil.getSession();
            session.delete(t);
            log.info("Delete:" + t);
        } catch (HibernateException e) {
            log.error("Error delete in Dao" + e);
            throw new ExceptionDAO(e);
        }
    }

    public Collection getAll()throws ExceptionDAO {
        List<T> allT = new ArrayList<T>();
        try{
            Session session = HibernateUtil.getSession();
            allT = session.createCriteria(getPersistentClass()).list();
        }catch (HibernateException e){
            log.error("Error getAll in Dao" + e);
            throw new ExceptionDAO(e);
        }
        return allT;
    }

    private Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
