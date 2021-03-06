package by.academy.it.belotserkovsky.dao;

import by.academy.it.belotserkovsky.dao.interfacies.IUserDao;
import by.academy.it.belotserkovsky.dto.UserDto;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.pojos.UserContacts;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by K.Belotserkovsky
 */

@ContextConfiguration("/testDao.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager")
@Transactional()
public class UserDaoTest {
    private String PARAM_NAME_LOGIN = "login";
    private String PARAM_NAME_PASS = "password";
    private Long id;

    @Autowired
    private IUserDao userDao;

    @Before
    public void before() throws Exception{
        User user = new User("firstname","lastname", PARAM_NAME_LOGIN, PARAM_NAME_PASS, "USER");
        UserContacts userContacts = new UserContacts("address", "12345678","email@gmail.com");
        user.setUserContacts(userContacts);
        userContacts.setUser(user);
        id = userDao.saveOrUpdate(user).getUserId();
    }

    @Test
    public void createUser() throws Exception {
        User user = userDao.get(id);
        userDao.saveOrUpdate(user);
    }

    @Test
    public void get()throws Exception {
        User user = userDao.get(id);
        assertNotNull(user);
    }

    @Test
    public void getByName()throws Exception {
        User user = userDao.getByUserName(PARAM_NAME_LOGIN);
        assertNotNull(user);
    }

    @Test
    public void getAll() throws Exception{
        List<User> list = userDao.getAll(0, 1);
        assertNotNull(list);
    }

    @Test
    public void getFoundRows(){
        int result = userDao.getFoundRows();
        assertEquals((result > 0), true);
    }
}