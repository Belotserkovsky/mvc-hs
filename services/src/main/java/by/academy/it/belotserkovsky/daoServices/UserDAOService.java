package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.UserDAO;
import by.academy.it.belotserkovsky.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Access to the class object UserDAO
 * Created by Kostya on 07.04.2016.
 */
public class UserDAOService {
    private UserDAO userDAO;

    private static UserDAOService instance;

    public static UserDAOService getInstance() {
        if (instance == null) {
            instance = new UserDAOService();
        }
        return instance;
    }

    public UserDAOService() {
        userDAO = UserDAO.getInstance();
    }

    public void addUser (User user) {
        try {
            if(user != null) {
                userDAO.create(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public User getUserByLoginPass(String login, String pass) {
        try {
            return userDAO.read(login, pass);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public void deleteUser(Object login){
        try {
            userDAO.isDelete(login);
        }catch (SQLException e){
            e.printStackTrace();;
        }
    }

    public List<User> getUsersList (){
        try{
            return userDAO.readAll();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
