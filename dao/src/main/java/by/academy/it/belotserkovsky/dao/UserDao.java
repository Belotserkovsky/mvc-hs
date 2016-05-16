package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.dto.UserDTO;
import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Class inherits the properties of BaseDao
 * Created by Kostya on 24.04.2016.
 */
public class UserDao extends BaseDao<User> {
    private static Logger log = Logger.getLogger(UserDao.class);
    Session session = null;

    /**
     * @param login
     * @param pass
     * @return
     * @throws ExceptionDAO
     */
    public User get(String login, String pass) throws ExceptionDAO {
        User user = null;
        log.info("Get user by login and pass:" + login +"-" + pass);
        try{
            session = HibernateUtil.getSession();
            String hql = "SELECT user FROM User user WHERE user.login=:login AND user.password=:pass";
            Query query = session.createQuery(hql);
            query.setCacheable(true);
            query.setParameter("login", login);
            query.setParameter("pass", pass);
            List<User> results = query.list();
            if(!results.isEmpty()){
                for(User result : results){
                    user = result;
                    log.info("Got user: " + user);
                }
            }
        }catch (HibernateException e){
            log.error("Error get user by login in Dao: " + e);
            throw new ExceptionDAO(e);
        }
        return user;
    }

    /**
     * @param uid
     * @return
     * @throws ExceptionDAO
     */
    public UserDTO getDTO(Long uid) throws ExceptionDAO {
        UserDTO userDTO = null;
        try {
            session = HibernateUtil.getSession();
            userDTO = (UserDTO) session.createSQLQuery("SELECT u.F_UID as uid, u.F_FIRSTNAME as firstName, " +
                    "u.F_SECONDNAME as secondName, u.F_LOGIN as login, " +
                    "u.F_PASSWORD as password, uc.F_ADDRESS as address, " +
                    "uc.F_PHONE as phone, uc.F_EMAIL as email " +
                    "from t_user u JOIN t_usercontacts uc ON u.F_UID=uc.F_UID WHERE u.F_UID="+uid)
                    .addScalar("uid", StandardBasicTypes.LONG)
                    .addScalar("firstName", StandardBasicTypes.STRING)
                    .addScalar("secondName", StandardBasicTypes.STRING)
                    .addScalar("login", StandardBasicTypes.STRING)
                    .addScalar("password", StandardBasicTypes.STRING)
                    .addScalar("address", StandardBasicTypes.STRING)
                    .addScalar("phone", StandardBasicTypes.STRING)
                    .addScalar("email", StandardBasicTypes.STRING)
                    .setResultTransformer(Transformers.aliasToBean(UserDTO.class)).uniqueResult();
        } catch (NonUniqueResultException e) {
            session.getTransaction().rollback();
            log.error(e.getMessage());
            HibernateUtil.closeSession();
        }
        return userDTO;
    }

    public List<UserDTO> getAll(int offset, int noOfRecords)throws ExceptionDAO{
        List<UserDTO> all = new ArrayList<UserDTO>();
        session = HibernateUtil.getSession();
        all = session.createSQLQuery("SELECT u.F_UID as uid, u.F_FIRSTNAME as firstName, " +
                "u.F_SECONDNAME as secondName, u.F_LOGIN as login, " +
                "u.F_PASSWORD as password, uc.F_ADDRESS as address, " +
                "uc.F_PHONE as phone, uc.F_EMAIL as email " +
                "from t_user u JOIN t_usercontacts uc ON u.F_UID=uc.F_UID LIMIT " + offset + "," + noOfRecords)
                .addScalar("uid", StandardBasicTypes.LONG)
                .addScalar("firstName", StandardBasicTypes.STRING)
                .addScalar("secondName", StandardBasicTypes.STRING)
                .addScalar("login", StandardBasicTypes.STRING)
                .addScalar("password", StandardBasicTypes.STRING)
                .addScalar("address", StandardBasicTypes.STRING)
                .addScalar("phone", StandardBasicTypes.STRING)
                .addScalar("email", StandardBasicTypes.STRING)
                .setResultTransformer(Transformers.aliasToBean(UserDTO.class)).list();
        return all;
    }

    public int getFoundRows() {
        Session session = HibernateUtil.getSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.setProjection(Projections.rowCount());
        Long result = (Long)criteria.uniqueResult();
        int foundRows = result.intValue();

        return foundRows;
    }
}
