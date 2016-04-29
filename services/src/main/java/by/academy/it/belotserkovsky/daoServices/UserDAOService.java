package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.UserDAO;
import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Access to the class object UserDAO
 * Created by Kostya on 07.04.2016.
 */
public class UserDAOService {
    private static Logger log = Logger.getLogger(UserDAOService.class);
    private Transaction transaction = null;

    private UserDAO userDAO = null;

    private static UserDAOService instance;

    public static synchronized UserDAOService getInstance() {
        if (instance == null) {
            instance = new UserDAOService();
        }
        return instance;
    }

    public UserDAOService() {
        userDAO = new UserDAO();
    }

    /**
     * @param newUser
     */
    public void createOrUpdate (User newUser) {
        try {
            if(newUser != null) {
                Session session = HibernateUtil.getSession();
                transaction = session.beginTransaction();
                userDAO.saveOrUpdate(newUser);
                transaction.commit();
            }
        }catch (ExceptionDAO e){
            transaction.rollback();
            log.error("DAO exception in service layer during createOrUpdate() user: " + e);
        }
    }

    /**
     * @param login
     * @param pass
     * @return
     */
    public User getUserByLoginPass(String login, String pass) {
        User user = new User();
        try {
            user = userDAO.get(login, pass);
        }catch (ExceptionDAO e){
            log.error("DAO exception in service layer during getUserByLoginPass(): " + e);
        }
        return user;
    }

    /**
     * @param user
     */
    public void deleteUser(User user){
        try {
            if (user != null){
                Session session = HibernateUtil.getSession();
                transaction = session.beginTransaction();
                userDAO.delete(user);
                transaction.commit();
                log.info("Successful delete user : " + user);
            }
        }catch (ExceptionDAO e){
            log.info("Failure delete user: " + user);
        }
    }

    public List<User> getAllUsers (){
        List<User> allUsers = new ArrayList<User>();
        try{
            allUsers = (List<User>)userDAO.getAll();
        }catch (ExceptionDAO e){
            log.error("DAO exception in service layer during getAll(): " + e);
        }
        return allUsers;
    }
}
