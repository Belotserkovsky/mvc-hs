package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.UserDao;
import by.academy.it.belotserkovsky.dto.UserDto;
import by.academy.it.belotserkovsky.exceptions.ExceptionDao;
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
 * Access to the class object UserDao
 * Created by Kostya on 07.04.2016.
 */
public class UserService {
    private static Logger log = Logger.getLogger(UserService.class);
    private Transaction transaction = null;
    private Session session = null;
    private int result;

    private UserDao userDAO = null;

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
        userDAO = new UserDao();
    }

    /**
     * @param
     */
    public void createOrUpdate (UserDto dtoUser) {
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
        }catch (ExceptionDao e){
            if(transaction != null){
                transaction.rollback();
            }
            log.error("Dao exception in service layer during createOrUpdate() user: " + e);
            HibernateUtil.closeSession();
        }
    }

    /**
     * @param login
     * @param pass
     * @return
     */
    public UserDto getUserByLoginPass(String login, String pass) {
        User user = null;
        UserDto userDto = null;
        try {
            user = userDAO.get(login, pass);
            if(user != null) {
                userDto = new UserDto();
                userDto.setUid(user.getUserId());
                userDto.setLogin(user.getLogin());
                userDto.setPassword(user.getPassword());
                userDto.setFirstName(user.getFirstName());
                userDto.setSecondName(user.getSecondName());
            }
        }catch (ExceptionDao e){
            HibernateUtil.getSession().getTransaction().rollback();
            log.error("Dao exception in service layer during getUserByLoginPass(): " + e);
            HibernateUtil.closeSession();
        }
        return userDto;
    }

    /**
     * @param uid
     * @return
     */
    public UserDto getUserWithContact(Long uid){
        UserDto userDto = null;
        try{
            userDto = userDAO.getDto(uid);
        }catch (ExceptionDao e){
            transaction = HibernateUtil.getSession().getTransaction();
            if(transaction != null){
             transaction.rollback();
            }
            log.error("Dao exception in service layer during getUserWithContact(): " + e);
        }
        return userDto;
    }

    /**
     * @param u_id
     * @return User
     */
    public User getById (Long u_id){
        User user = null;
        if(u_id != null) {
            try {
                user = userDAO.get(u_id);
            } catch (ExceptionDao e) {
                HibernateUtil.getSession().getTransaction().rollback();
                log.error("Dao exception in service layer during getById(): " + e);
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
    public List<UserDto> getAllUsers (int offset, int noOfRecords){
        List<UserDto> allUsers = null;
        try{
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            allUsers = userDAO.getAll(offset, noOfRecords);
            transaction.commit();
        }catch (ExceptionDao e) {
            transaction.rollback();
            log.error("Dao exception in service layer during getAll(): " + e);
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
