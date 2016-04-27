package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.UserDAO;
import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.pojos.UserContacts;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

/**
 * Access to the class object UserDAO
 * Created by Kostya on 07.04.2016.
 */
public class UserDAOService {
    private static Logger log = Logger.getLogger(UserDAOService.class);
    private UserDAO userDAO;

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

    public void createOrUpdate (User user) {
        try {
            if(user != null) {
                userDAO.saveOrUpdate(user);
            }
        }catch (ExceptionDAO e){
            log.error("DAO exception in service layer during createOrUpdate() user: " + e);
        }
    }

    public User getUserByLoginPass(String login, String pass) {
        try {
            return userDAO.get(login, pass);
        }catch (ExceptionDAO e){
            log.error("DAO exception in service layer during getUserByLoginPass(): " + e);
            return null;
        }
    }

    public void deleteUser(User user){
        try {
            if (user != null){
                userDAO.delete(user);
                log.info("Successful delete user : " + user);
            }
        }catch (ExceptionDAO e){
            log.info("Failure delete user: " + user);
        }
    }
//
//    public List<User> getUsersList (){
//        try{
//            return userDAO.readAll();
//        }catch (SQLException e){
//            log.error("SQLException: " + e);
//        }
//        return null;
//    }
}
