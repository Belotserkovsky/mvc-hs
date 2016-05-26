package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dao.interfacies.IUserDao;
import by.academy.it.belotserkovsky.dto.UserDto;
import by.academy.it.belotserkovsky.pojos.Bid;
import by.academy.it.belotserkovsky.pojos.User;
import by.academy.it.belotserkovsky.pojos.UserContacts;
import by.academy.it.belotserkovsky.pojos.constants.Role;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Access to the class object UserDao
 * Created by K.Belotserkovsky
 */

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class UserService implements IUserService{
    private static Logger log = Logger.getLogger(UserService.class);
    private int result;

    @Autowired
    private IUserDao userDAO;


    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void createOrUpdateUser (UserDto userDto) {
        Long uid = userDto.getUserId();
        if(uid != null) {
            User user = userDAO.get(userDto.getUserId());
            user.setFirstName(userDto.getFirstName());
            user.setSecondName(userDto.getSecondName());
            user.setUserName(userDto.getUserName());
            user.setPassword(userDto.getPassword());
            UserContacts uContacts = user.getUserContacts();
            uContacts.setAddress(userDto.getAddress());
            uContacts.setPhone(userDto.getPhone());
            uContacts.setEmail(userDto.getEmail());
            userDAO.saveOrUpdate(user);
        }else{
            User user = new User(userDto.getFirstName(), userDto.getSecondName(),
                    userDto.getUserName(), userDto.getPassword(), Role.USER.getType());
            UserContacts uContacts = new UserContacts(userDto.getAddress(), userDto.getPhone(),
                    userDto.getEmail());
            Set<Bid> bids = new HashSet<Bid>();
            user.setBids(bids);
            user.setUserContacts(uContacts);
            uContacts.setUser(user);
            userDAO.saveOrUpdate(user);
        }
    }

    public User getUserByUserName(String userName) {
        User user = userDAO.getByUserName(userName);
        return user;
    }

    public UserDto getUserDto(Long userId){
        User user = userDAO.get(userId);
        UserDto userDto = new UserDto(user.getUserId(), user.getFirstName(), user.getSecondName(),
                user.getUserName(), user.getPassword(),user.getUserContacts().getAddress(),
                user.getUserContacts().getPhone(), user.getUserContacts().getEmail(), user.getRole());
        return userDto;
    }

    public User getUserById (Long userId){
        User user = null;
        if(userId != null) {
            user = userDAO.get(userId);
        }
        return user;
    }

    public List<User> getUsers (int offset, int numberOfRecords){
        List<User> allUsers = userDAO.getAll(offset, numberOfRecords);
        return allUsers;
    }

    public int getRowsUsers(){
        result = userDAO.getFoundRows();
        return result;
    }
}
