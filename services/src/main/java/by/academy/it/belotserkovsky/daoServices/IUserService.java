package by.academy.it.belotserkovsky.daoServices;

import by.academy.it.belotserkovsky.dto.UserDto;
import by.academy.it.belotserkovsky.pojos.User;

import java.util.List;

/**
 * Created by K.Belotserkovsky
 */
public interface IUserService {

    /**
     * @param userDto
     */
    void createOrUpdateUser(UserDto userDto);

    /**
     * @param login
     * @param password
     * @return userDto
     */
    UserDto getUserDtoByLoginPass(String login, String password);

    /**
     * @param userId
     * @return UserDto
     */
    UserDto getUserDto(Long userId);

    /**
     * @param userId
     * @return User
     */
    User getUserById(Long userId);

    /**
     * @param offset
     * @param numberOfRecords
     * @return List users for pagination
     */
    List<User> getUsers(int offset, int numberOfRecords);

    /**
     * @return Number of rows in user's table
     */
    int getRowsUsers();
}
