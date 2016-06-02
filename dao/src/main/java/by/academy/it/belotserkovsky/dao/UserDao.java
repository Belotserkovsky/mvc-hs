package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.dao.interfacies.IUserDao;
import by.academy.it.belotserkovsky.pojos.User;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Class inherits the properties of BaseDao
 * Created by K.Belotserkovsky
 */

@Repository
public class UserDao extends BaseDao<User> implements IUserDao {
    private static Logger log = Logger.getLogger(UserDao.class);

    @Autowired
    public UserDao(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    public User getByUserName(String userName){
        log.info("Get user by userName:" + userName);
        String hql = "SELECT user FROM User user WHERE user.userName=:userName";
        Query query = getSession().createQuery(hql);
        query.setParameter("userName", userName);
        User user = (User)query.uniqueResult();
        return user;
    }

    public List<User> getAll(int offset, int numberOfRecords) {
        String hql = "FROM User";
        List<User> all = getSession().createQuery(hql).setFirstResult(offset).setMaxResults(numberOfRecords).list();
        return all;
    }

    public int getFoundRows() {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.setProjection(Projections.rowCount());
        Long result = (Long)criteria.uniqueResult();
        int foundRows = result.intValue();

        return foundRows;
    }
}
