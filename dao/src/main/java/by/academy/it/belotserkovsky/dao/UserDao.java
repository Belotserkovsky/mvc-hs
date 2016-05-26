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

    public User getByLoginPass(String login, String pass){
        User user = null;
        log.info("Get user by login and pass:" + login +"-" + pass);
        String hql = "SELECT user FROM User user WHERE user.login=:login AND user.password=:pass";
        Query query = getSession().createQuery(hql);
        query.setParameter("login", login);
        query.setParameter("pass", pass);
        List<User> results = query.list();
        if(!results.isEmpty()){
            for(User result : results){
                user = result;
                log.info("Got user: " + user);
            }
        }
        return user;
    }

    public List<User> getAll(int offset, int numberOfRecords) {
        String hql = "FROM User";
        List<User> all = getSession().createQuery(hql).setFirstResult(offset).setMaxResults(numberOfRecords).list();
        return all;


//        all = session.createSQLQuery("SELECT u.F_UID as uid, u.F_FIRSTNAME as firstName, " +
//                "u.F_SECONDNAME as secondName, u.F_LOGIN as login, " +
//                "u.F_PASSWORD as password, uc.F_ADDRESS as address, " +
//                "uc.F_PHONE as phone, uc.F_EMAIL as email " +
//                "from t_user u JOIN t_usercontacts uc ON u.F_UID=uc.F_UID LIMIT " + offset + "," + noOfRecords)
//                .addScalar("uid", StandardBasicTypes.LONG)
//                .addScalar("firstName", StandardBasicTypes.STRING)
//                .addScalar("secondName", StandardBasicTypes.STRING)
//                .addScalar("login", StandardBasicTypes.STRING)
//                .addScalar("password", StandardBasicTypes.STRING)
//                .addScalar("address", StandardBasicTypes.STRING)
//                .addScalar("phone", StandardBasicTypes.STRING)
//                .addScalar("email", StandardBasicTypes.STRING)
//                .setResultTransformer(Transformers.aliasToBean(UserDto.class)).list();
    }

    public int getFoundRows() {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.setProjection(Projections.rowCount());
        Long result = (Long)criteria.uniqueResult();
        int foundRows = result.intValue();

        return foundRows;
    }
}
