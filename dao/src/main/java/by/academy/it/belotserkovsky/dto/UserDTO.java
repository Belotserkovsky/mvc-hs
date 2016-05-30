package by.academy.it.belotserkovsky.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Date Transfer Object
 * Created by K.Belotserkovsky
 */
public class UserDto {

    private Long userId;

    @Size(max = 30, message = "Maximum length 30 symbols")
    private String firstName;

    @Size(max = 30, message = "Maximum length 30 symbols")
    private String secondName;

    @Size(min = 3, max = 20, message = "Username must be between 6 and 20 characters long.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no spaces")
    private String userName;

    @Size(min = 3, max = 20, message = "Password must be between 6 and 20 characters long.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Password must be alphanumeric with no spaces")
    private String password;

    @Size(max = 30, message = "Maximum length 30 symbols")
    private String address;

    @Size(max = 20, message = "Maximum length 20 symbols")
    @Pattern(regexp = "^[0-9+-]+()", message = "Incorrect phone number. You need to use numeric 0-9, symbols +-()")
    private String phone;

    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,4}", message="Incorrect email address.")
    private String email;

    private String userRole;

    public UserDto() {
    }

    public UserDto(Long userId, String firstName, String secondName, String userName, String password, String address, String phone, String email, String userRole) {
        this.userId = userId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.userRole = userRole;
    }

    public UserDto(String firstName, String secondName, String userName, String password, String address, String phone, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public UserDto(String firstName, String secondName, String userName, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.userName = userName;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
