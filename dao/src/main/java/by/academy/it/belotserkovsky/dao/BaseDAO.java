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

/**
 * Created by Kostya on 22.04.2016.
 */
public class BaseDAO<T> implements DAO<T>{

    public static HibernateUtil util = null;
    private static Logger log = Logger.getLogger(BaseDAO.class);
    private Transaction transaction = null;

    public void saveOrUpdate(T t) throws ExceptionDAO{
        util = HibernateUtil.getHibernateUtil();
        try {
            Session session = util.getSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(t);
            log.info("saveOrUpdate(t):" + t);
            transaction.commit();
            log.info("Save or update (commit):" + t);
        } catch (HibernateException e) {
            log.error("Error save or update in Dao" + e);
            transaction.rollback();
            throw new ExceptionDAO(e);
        }
    }

    public T get(Serializable id) throws ExceptionDAO {
        util = HibernateUtil.getHibernateUtil();
        log.info("Get class by id:" + id);
        T t = null;
        try {
            Session session = util.getSession();
            transaction = session.beginTransaction();
            t = (T) session.get(getPersistentClass(), id);
            transaction.commit();
            log.info("get clazz:" + t);
        } catch (HibernateException e) {
            transaction.rollback();
            log.error("Error get " + getPersistentClass() + " in Dao" + e);
            throw new ExceptionDAO(e);
        }
        return t;
    }

    public T load(Serializable id) throws ExceptionDAO {
        util = HibernateUtil.getHibernateUtil();
        log.info("Load class by id:" + id);
        T t = null;
        try {
            Session session = util.getSession();
            transaction = session.beginTransaction();
            t = (T) session.load(getPersistentClass(), id);
            log.info("load() clazz:" + t);
            session.isDirty();
            transaction.commit();
        } catch (HibernateException e) {
            log.error("Error load() " + getPersistentClass() + " in Dao" + e);
            transaction.rollback();
            throw new ExceptionDAO(e);
        }
        return t;
    }

    public void delete(T t) throws ExceptionDAO {
        util = HibernateUtil.getHibernateUtil();
        try {
            Session session = util.getSession();
            transaction = session.beginTransaction();
            session.delete(t);
            transaction.commit();
            log.info("Delete:" + t);
        } catch (HibernateException e) {
            log.error("Error delete in Dao" + e);
            transaction.rollback();
            throw new ExceptionDAO(e);
        }
    }

    private Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
