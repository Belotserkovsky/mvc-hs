package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.dao.interfacies.Dao;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Parent class Dao
 * Created by K.Belotserkovsky
 * @param <T>
 */

@Repository
public class BaseDao<T> implements Dao<T> {
    private static Logger log = Logger.getLogger(BaseDao.class);
    private SessionFactory sessionFactory;

    @Autowired
    public BaseDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public T saveOrUpdate(T t){
        getSession().saveOrUpdate(t);
        log.info("Save or update:" + t);
        return (T)t;
    }

    public T get(Serializable id) {
        log.info("Get:" + id);
        return (T) getSession().get(getPersistentClass(), id);
    }

    public void delete(T t){
        getSession().delete(t);
        log.info("Delete:" + t);
    }

    private Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
