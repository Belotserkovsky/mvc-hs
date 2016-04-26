package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.pojos.UserContacts;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;

/**
 * Created by Kostya on 24.04.2016.
 */
public class UserDAO extends BaseDAO<User>{
    private static Logger log = Logger.getLogger(UserDAO.class);
    private Transaction transaction = null;

    public User get(String login, String pass) throws ExceptionDAO {
        util = HibernateUtil.getHibernateUtil();
        User user = null;
        log.info("Get user by login and pass:" + login + pass);
        try{
            Session session = util.getSession();
            transaction = session.beginTransaction();
            String hql = "SELECT user FROM User user WHERE user.login=:login AND user.password=:pass";
            Query query = session.createQuery(hql);
            query.setParameter("login", login);
            query.setParameter("pass", pass);
            user = (User)query.uniqueResult();
            transaction.commit();
            log.info("Get user: " + user);
        }catch (HibernateException e){
            log.error("Error get user by login in DAO: " + e);
            transaction.rollback();
            throw new ExceptionDAO(e);
        }
        return user;
    }

    public void flush(Long id, UserContacts uc) throws ExceptionDAO {
        try {
            Session session = util.getSession();
            User user = (User)session.get(User.class, id);
            user.setUserContacts(uc);
            session.flush();
            log.info("User has contacts: " + uc);
        } catch (HibernateException e) {
            log.error("Error Flush user" + e);
            throw new ExceptionDAO(e);
        }
    }
}
