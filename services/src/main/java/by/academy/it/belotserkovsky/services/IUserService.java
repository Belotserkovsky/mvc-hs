package by.academy.it.belotserkovsky.services;

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
    Long createOrUpdateUser(UserDto userDto);

    /**
     * @param userName
     * @return user
     */
    User getUserByUserName(String userName);

    /**
     * @param userName
     * @return UserDto
     */
    UserDto getUserDto(String userName);

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
