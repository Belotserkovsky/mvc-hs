package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dto.UserDto;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Администратор on 26.04.2016.
 */
public class UserServiceTest {
//    Session session = null;
//    Transaction transaction = null;
//
//    @Test
//    public void getUserByLoginPass() throws Exception {
//        session = HibernateUtil.getSession();
//        transaction = session.beginTransaction();
//        UserDto user = UserService.getInstance().getUserByLoginPass("login", "password");
//        assertNotNull(user);
//        transaction.commit();
//        HibernateUtil.closeSession();
//    }
//
//    @Test
//    public void createOrUpdate(){
//        Long uid = Long.parseLong("1");
//        UserDto uDTO = new UserDto(uid, "newname", "newname", "login", "password", "newaddress", "123456789", "newemail");
//        UserService.getInstance().createOrUpdate(uDTO);
//        HibernateUtil.closeSession();
//    }
//
//    @Test
//    public void getUsers(){
//        List<User> result = UserService.getInstance().getUsers(0, 1);
//        assertNotNull(result);
//        HibernateUtil.closeSession();
//    }
//
//    @Test
//    public void getUserWithContact(){
//        session = HibernateUtil.getSession();
//        transaction = session.beginTransaction();
//        UserDto uDTO = UserService.getInstance().getUserDto(Long.parseLong("1"));
//        assertNotNull(uDTO);
//        transaction.commit();
//        HibernateUtil.closeSession();
//    }
//
//    @Test
//    public void getById(){
//        session = HibernateUtil.getSession();
//        transaction = session.beginTransaction();
//        User user = UserService.getInstance().getUserById(Long.parseLong("1"));
//        assertNotNull(user);
//        transaction.commit();
//        HibernateUtil.closeSession();
//    }
//
//    @Test
//    public void getRowsUsers(){
//        session = HibernateUtil.getSession();
//        transaction = session.beginTransaction();
//        int result = UserService.getInstance().getRowsUsers();
//        assertEquals((result > 0), true);
//        transaction.commit();
//        HibernateUtil.closeSession();
//    }
}