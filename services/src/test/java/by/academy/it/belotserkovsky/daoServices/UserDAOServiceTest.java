package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.UserContactsDAO;
import by.academy.it.belotserkovsky.dto.UserDTO;
import by.academy.it.belotserkovsky.exceptions.ExceptionDAO;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.pojos.UserContacts;
import by.academy.it.belotserkovsky.utils.HibernateUtil;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Администратор on 26.04.2016.
 */
public class UserDAOServiceTest {
    Session session = null;
    Transaction transaction = null;

    @Test
    public void getUserByLoginPass() throws Exception {
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        UserDTO user = UserDAOService.getInstance().getUserByLoginPass("login", "password");
        assertNotNull(user);
        transaction.commit();
        HibernateUtil.closeSession();
    }

    @Test
    public void createOrUpdate(){
        Long uid = Long.parseLong("1");
        UserDTO uDTO = new UserDTO(uid, "newname", "newname", "login", "password", "newaddress", "123456789", "newemail");
        UserDAOService.getInstance().createOrUpdate(uDTO);
        HibernateUtil.closeSession();
    }

    @Test
    public void getAllUsers(){
        List<UserDTO> result = UserDAOService.getInstance().getAllUsers(0, 1);
        assertNotNull(result);
        HibernateUtil.closeSession();
    }

    @Test
    public void getUserWithContact(){
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        UserDTO uDTO = UserDAOService.getInstance().getUserWithContact(Long.parseLong("1"));
        assertNotNull(uDTO);
        transaction.commit();
        HibernateUtil.closeSession();
    }

    @Test
    public void getById(){
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        User user = UserDAOService.getInstance().getById(Long.parseLong("1"));
        assertNotNull(user);
        transaction.commit();
        HibernateUtil.closeSession();
    }

    @Test
    public void getRowsUsers(){
        session = HibernateUtil.getSession();
        transaction = session.beginTransaction();
        int result = UserDAOService.getInstance().getRowsUsers();
        assertEquals((result > 0), true);
        transaction.commit();
        HibernateUtil.closeSession();
    }
}