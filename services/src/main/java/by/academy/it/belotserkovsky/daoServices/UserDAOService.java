package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.UserDAO;
import by.academy.it.belotserkovsky.dto.UserDTO;
import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.pojos.UserContacts;
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
     * @param
     */
    public void createOrUpdate (UserDTO dtoUser) {
        try {
            if(dtoUser != null) {
                Session session = HibernateUtil.getSession();
                transaction = session.beginTransaction();
                if(dtoUser.getUserId() != null) {
                    User user = new User(dtoUser.getUserId(), dtoUser.getFirstName(), dtoUser.getSecondName(), dtoUser.getLogin(), dtoUser.getPassword());
                    UserContacts uContacts = new UserContacts(dtoUser.getAddress(), dtoUser.getPhone(), dtoUser.getEmail());
                    user.setUserContacts(uContacts);
                    uContacts.setUser(user);
                    userDAO.saveOrUpdate(user);
                }
                User user = new User(dtoUser.getFirstName(), dtoUser.getSecondName(), dtoUser.getLogin(), dtoUser.getPassword());
                UserContacts uContacts = new UserContacts(dtoUser.getAddress(), dtoUser.getPhone(), dtoUser.getEmail());
                user.setUserContacts(uContacts);
                uContacts.setUser(user);
                userDAO.saveOrUpdate(user);
                transaction.commit();
                HibernateUtil.closeSession();
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
    public UserDTO getUserByLoginPass(String login, String pass) {
        UserDTO userDTO = null;
        User user = null;
        try {
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            user = userDAO.get(login, pass);
            if(user != null) {
                userDTO = new UserDTO();
                userDTO.setUserId(user.getUid());
                userDTO.setLogin(user.getLogin());
                userDTO.setPassword(user.getPassword());
                userDTO.setFirstName(user.getFirstName());
                userDTO.setSecondName(user.getSecondName());
                transaction.commit();
                return userDTO;
            }
        }catch (ExceptionDAO e){
            transaction.rollback();
            log.error("DAO exception in service layer during getUserByLoginPass(): " + e);
        }
        return userDTO;
    }

    /**
     * @param uid
     * @return
     */
    public UserDTO getUserWithContact(Long uid){
        UserDTO userDTO = null;
        try{
            Session session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            userDTO = userDAO.getDTO(uid);
            transaction.commit();
        }catch (ExceptionDAO e){
            transaction.rollback();
            log.error("DAO exception in service layer during getUserWithContact(): " + e);
        }
        return userDTO;
    }

    /**
     * @param userDTO
     */
    public void deleteUser(UserDTO userDTO){
        User user = null;
        try {
            if (userDTO != null){
                Session session = HibernateUtil.getSession();
                transaction = session.beginTransaction();
                user = userDAO.get(userDTO.getUserId());
                userDAO.delete(user);
                transaction.commit();
                log.info("Successful delete user : " + user);
            }
        }catch (ExceptionDAO e){
            log.info("Failure delete user: " + user);
        }
    }

    public User getById (Long uid){
        User user = null;
        try{
            user = userDAO.get(uid);
        }catch (ExceptionDAO e){
            log.error("DAO exception in service layer during getUserWithContact(): " + e);
        }
        return user;
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
