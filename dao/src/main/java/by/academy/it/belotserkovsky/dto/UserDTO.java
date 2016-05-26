package by.academy.it.belotserkovsky.dto;

/**
 * Date Transfer Object
 * Created by K.Belotserkovsky
 */
public class UserDto {

    private Long userId;
    private String firstName;
    private String secondName;
    private String userName;
    private String password;
    private String address;
    private String phone;
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
