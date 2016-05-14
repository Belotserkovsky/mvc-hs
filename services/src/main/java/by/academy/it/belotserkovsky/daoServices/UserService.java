package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.UserDAO;
import by.academy.it.belotserkovsky.dto.UserDTO;
import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import by.academy.it.belotserkovsky.pojos.Bid;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.pojos.UserContacts;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Access to the class object UserDAO
 * Created by Kostya on 07.04.2016.
 */
public class UserService {
    private static Logger log = Logger.getLogger(UserService.class);
    private Transaction transaction = null;
    private Session session = null;
    private int result;

    private UserDAO userDAO = null;

    private static UserService instance;

    /**
     * @return Singleton
     */
    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public UserService() {
        userDAO = new UserDAO();
    }

    /**
     * @param
     */
    public void createOrUpdate (UserDTO dtoUser) {
        Long uid = dtoUser.getUid();
        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            if(uid != null) {
                User user = userDAO.get(dtoUser.getUid());
                user.setFirstName(dtoUser.getFirstName());
                user.setSecondName(dtoUser.getSecondName());
                user.setLogin(dtoUser.getLogin());
                user.setPassword(dtoUser.getPassword());
                UserContacts uContacts = user.getUserContacts();
                uContacts.setAddress(dtoUser.getAddress());
                uContacts.setPhone(dtoUser.getPhone());
                uContacts.setEmail(dtoUser.getEmail());
                userDAO.saveOrUpdate(user);
            }else{
                User user = new User(dtoUser.getFirstName(), dtoUser.getSecondName(), dtoUser.getLogin(), dtoUser.getPassword());
                UserContacts uContacts = new UserContacts(dtoUser.getAddress(), dtoUser.getPhone(), dtoUser.getEmail());
                Set<Bid> bids = new HashSet<Bid>();
                user.setBids(bids);
                user.setUserContacts(uContacts);
                uContacts.setUser(user);
                userDAO.saveOrUpdate(user);
            }
            transaction.commit();
        }catch (ExceptionDAO e){
            if(transaction != null){
                transaction.rollback();
            }
            log.error("DAO exception in service layer during createOrUpdate() user: " + e);
            HibernateUtil.closeSession();
        }
    }

    /**
     * @param login
     * @param pass
     * @return
     */
    public UserDTO getUserByLoginPass(String login, String pass) {
        User user = null;
        UserDTO userDTO = null;
        try {
            user = userDAO.get(login, pass);
            if(user != null) {
                userDTO = new UserDTO();
                userDTO.setUid(user.getUid());
                userDTO.setLogin(user.getLogin());
                userDTO.setPassword(user.getPassword());
                userDTO.setFirstName(user.getFirstName());
                userDTO.setSecondName(user.getSecondName());
            }
        }catch (ExceptionDAO e){
            HibernateUtil.getSession().getTransaction().rollback();
            log.error("DAO exception in service layer during getUserByLoginPass(): " + e);
            HibernateUtil.closeSession();
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
            userDTO = userDAO.getDTO(uid);
        }catch (ExceptionDAO e){
            transaction = HibernateUtil.getSession().getTransaction();
            if(transaction != null){
             transaction.rollback();
            }
            log.error("DAO exception in service layer during getUserWithContact(): " + e);
        }
        return userDTO;
    }

    /**
     * @param uid
     * @return User
     */
    public User getById (Long uid){
        User user = null;
        if(uid != null) {
            try {
                user = userDAO.get(uid);
            } catch (ExceptionDAO e) {
                HibernateUtil.getSession().getTransaction().rollback();
                log.error("DAO exception in service layer during getById(): " + e);
                HibernateUtil.closeSession();
            }
        }
        return user;
    }

    /**
     * @param offset
     * @param noOfRecords
     * @return List users for pagination
     */
    public List<UserDTO> getAllUsers (int offset, int noOfRecords){
        List<UserDTO> allUsers = null;
        try{
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            allUsers = userDAO.getAll(offset, noOfRecords);
            transaction.commit();
        }catch (ExceptionDAO e) {
            transaction.rollback();
            log.error("DAO exception in service layer during getAll(): " + e);
        }
        return allUsers;
    }

    /**
     * @return Number of rows in user's table
     */
    public int getRowsUsers(){
        result = userDAO.getFoundRows();
        return result;
    }
}
