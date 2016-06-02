package by.academy.it.belotserkovsky.services;

import by.academy.it.belotserkovsky.dto.UserDto;
import by.academy.it.belotserkovsky.pojos.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by K.Belotserkovsky
 */

@ContextConfiguration("/testServices.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager")
@Transactional()
public class UserServiceTest {
    private static String PARAM_FIRST_NAME = "firstName";
    private static String PARAM_SECOND_NAME = "secondName";
    private static String PARAM_USER_NAME = "userName";
    private static String PARAM_USER_NAME_2 = "userName2";
    private static String PARAM_PASS = "password";
    private static String PARAM_ADDRESS = "address";
    private static String PARAM_PHONE = "phone";
    private static String PARAM_EMAIL = "email";
    private UserDto userDto = null;
    private Long userId;

    @Autowired
    IUserService userService;

    @Before
    public void before(){
        userDto = new UserDto();
        userDto.setFirstName(PARAM_FIRST_NAME); userDto.setSecondName(PARAM_SECOND_NAME); userDto.setUserName(PARAM_USER_NAME);
        userDto.setPassword(PARAM_PASS); userDto.setAddress(PARAM_ADDRESS); userDto.setPhone(PARAM_PHONE);
        userDto.setEmail(PARAM_EMAIL);
        userService.createOrUpdateUser(userDto);
    }

    @Test
    public void getUserByUserName() throws Exception {
        User user = userService.getUserByUserName(PARAM_USER_NAME);
        assertNotNull(user);
    }

    @Test
    public void createOrUpdate(){
        UserDto userDto = new UserDto();
        userDto.setFirstName(PARAM_FIRST_NAME); userDto.setSecondName(PARAM_SECOND_NAME); userDto.setUserName(PARAM_USER_NAME_2);
        userDto.setPassword(PARAM_PASS); userDto.setAddress(PARAM_ADDRESS); userDto.setPhone(PARAM_PHONE);
        userDto.setEmail(PARAM_EMAIL);
        userId = userService.createOrUpdateUser(userDto);
        assertNotNull(userId);
    }

    @Test
    public void getUsers(){
        List<User> list = userService.getUsers(0, 1);
        assertNotNull(list);
    }

    @Test
    public void getUserDto(){
        UserDto userDto = userService.getUserDto(PARAM_USER_NAME);
        assertNotNull(userDto);

    }

    @Test
    public void getRowsUsers(){
        int result = userService.getRowsUsers();
        assertEquals((result > 0), true);
    }
}