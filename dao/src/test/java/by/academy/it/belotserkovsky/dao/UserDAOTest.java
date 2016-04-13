package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.entity.User;
import by.academy.it.belotserkovsky.poolConnection.DataSource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import static org.junit.Assert.*;

/**
 * testing UserDAO methods
 * Created by Администратор on 13.04.2016.
 */
public class UserDAOTest {

    private UserDAO userDAO;

    @Test
    public void create() throws Exception {
        User user = new User();

        user.setAddress("address");
        user.setEmail("email");
        user.setLogin("login");
        user.setPassword("password");
        user.setFullName("First name, Second name");
        user.setPhone("phone");

        userDAO = UserDAO.getInstance();
        userDAO.create(user);

        List<User> usersList = UserDAO.getInstance().readAll();

        Assert.assertEquals(1, usersList.size());
        Assert.assertEquals(user.getEmail(), usersList.get(0).getEmail());

    }

    @After
    public void deleteAll() throws Exception{
        Connection connection = null;
        Statement statement = null;
        String query = "DELETE * FROM users";

        connection = DataSource.getInstance().getConnection();
        statement = connection.createStatement();

        statement.execute(query);

        statement.close();
        connection.close();
    }

}