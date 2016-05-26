package by.academy.it.belotserkovsky.dao.interfacies;

import java.io.Serializable;
import java.util.List;

/**
 * General interface Dao
 * Created by K.Belotserkovsky
 */
public interface Dao<T>{

    /**
     * @param t
     */
    T saveOrUpdate(T t);

    /**
     * @param id
     * @return T
     */
    T get(Serializable id);

    /**
     * @param t
     */
    void delete(T t);

}
