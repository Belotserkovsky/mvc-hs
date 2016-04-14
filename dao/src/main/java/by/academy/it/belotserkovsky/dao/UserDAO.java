package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.entity.User;
import by.academy.it.belotserkovsky.poolConnection.DataSource;
import org.apache.log4j.Logger;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * implementation interface dao for user
 * Created by Kostya on 06.04.2016.
 */
public class UserDAO implements DAO<User> {
    private static UserDAO instance;
    private static Logger log = Logger.getLogger(UserDAO.class);

    private final String COLUMN_NAME_ID = "u_id";
    private final String COLUMN_NAME_FULLNAME = "fullName";
    private final String COLUMN_NAME_ADDRESS = "address";
    private final String COLUMN_NAME_PHONE = "phone";
    private final String COLUMN_NAME_EMAIL = "email";
    private final String COLUMN_NAME_LOGIN = "login";
    private final String COLUMN_NAME_PASSWORD = "password";

    private final String SQL_QUERY_CHECK_LOGIN_PASS = "SELECT * FROM users WHERE login = ? AND password = ?";
    private final String SQL_QUERY_CREATE_USER = "INSERT INTO users (fullName, address, phone, email, login, password) VALUES (?,?,?,?,?,?)";
    private final String SQL_QUERY_READ_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
    private final String SQL_QUERY_READALL_USERS = "SELECT * FROM users";
    private final String SQL_QUERY_DELETE_USER_BY_LOGIN = "DELETE FROM users WHERE login = ?";

    private UserDAO() {
        super();
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    public User read (String login, String pass) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        User user = null;
        String query = SQL_QUERY_CHECK_LOGIN_PASS;

        try {
            connection = DataSource.getInstance().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, login.trim());
            ps.setString(2, pass.trim());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt(COLUMN_NAME_ID));
                user.setFullName(rs.getString(COLUMN_NAME_FULLNAME));
                user.setAddress(rs.getString(COLUMN_NAME_ADDRESS));
                user.setPhone(rs.getString(COLUMN_NAME_PHONE));
                user.setEmail(rs.getString(COLUMN_NAME_EMAIL));
                user.setLogin(rs.getString(COLUMN_NAME_LOGIN));
                user.setPassword(rs.getString(COLUMN_NAME_PASSWORD));

                log.info("Read: " + user);
                return user;
            }
        } catch (PropertyVetoException e) {
            log.error("c3p0 exception: " + e);
        } catch (IOException e) {
            log.error("c3p0 exception: " + e);
        } finally {
            ps.close();
            connection.close();
        }
        return user;
    }

    public void create(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        String query = SQL_QUERY_CREATE_USER;
        try {
            connection = DataSource.getInstance().getConnection();
            ps = connection.prepareStatement(query);

            ps.setString(1, user.getFullName());
            ps.setString(2, user.getAddress());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getLogin());
            ps.setString(6, user.getPassword());

            ps.executeUpdate();
            log.info("Create: " + user);

        } catch (PropertyVetoException e) {
            log.error("c3p0 exception: " + e);
        } catch (IOException e) {
            log.error("c3p0 exception: " + e);
        } finally {
            ps.close();
            connection.close();
        }
    }

    public User read (Object login) throws SQLException{
        Connection connection = null;
        PreparedStatement ps = null;
        User user = null;
        String query = SQL_QUERY_READ_USER_BY_LOGIN;
        try{
            connection = DataSource.getInstance().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, (String)login);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                user = new User();
                user.setId(rs.getInt(COLUMN_NAME_ID));
                user.setFullName(rs.getString(COLUMN_NAME_FULLNAME));
                user.setAddress(rs.getString(COLUMN_NAME_ADDRESS));
                user.setLogin(rs.getString(COLUMN_NAME_LOGIN));
                user.setPassword(rs.getString(COLUMN_NAME_PASSWORD));

                log.info("Read: " + user);
                return user;
            }
        }catch (PropertyVetoException e){
            log.error("c3p0 exception: " + e);
        }catch (IOException e){
            log.error("c3p0 exception: " + e);
        }finally {
            ps.close();
            connection.close();
        }
        return user;
    }

    public boolean isUpdate(User user) throws SQLException{ return false;}

    public boolean isDelete(Object login) throws SQLException{
        Connection connection = null;
        PreparedStatement ps = null;
        String query = SQL_QUERY_DELETE_USER_BY_LOGIN;

        try{
            connection = DataSource.getInstance().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, login.toString());

            if(ps.executeUpdate() > 0){
                log.info("Delete: " + login);
                return true;
            }

        }catch (PropertyVetoException e){
            log.error("c3p0 exception: " + e);
        }catch (IOException e){
            log.error("c3p0 exception: " + e);
        }finally {
            ps.close();
            connection.close();
        }
        return false;
    }

    public List<User> readAll() throws SQLException{
        Connection connection = null;
        PreparedStatement ps = null;
        User user = null;
        List<User> allUsers = new ArrayList<User>();
        String query = SQL_QUERY_READALL_USERS;
        try {
            connection = DataSource.getInstance().getConnection();
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                user = new User();
                user.setId(rs.getInt(COLUMN_NAME_ID));
                user.setFullName(rs.getString(COLUMN_NAME_FULLNAME));
                user.setAddress(rs.getString(COLUMN_NAME_ADDRESS));
                user.setLogin(rs.getString(COLUMN_NAME_LOGIN));
                user.setPassword(rs.getString(COLUMN_NAME_PASSWORD));
                allUsers.add(user);
            }
        }catch (PropertyVetoException e){
            log.error("c3p0 exception: " + e);
        }catch (IOException e){
            log.error("c3p0 exception: " + e);
        } finally {
            ps.close();
            connection.close();
        }
        log.info("Read all users: " + allUsers);
        return allUsers;
    }
}

