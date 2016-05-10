package by.academy.it.belotserkovsky.dto;

/**
 * Created by Kostya on 30.04.2016.
 */
public class UserDTO {

    private Long uid;
    private String firstName;
    private String secondName;
    private String login;
    private String password;
    private String address;
    private String phone;
    private String email;

    public UserDTO() {
    }

    public UserDTO(Long uid, String firstName, String secondName, String login, String password, String address, String phone, String email) {
        this.uid = uid;
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public UserDTO(String firstName, String secondName, String login, String password, String address, String phone, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public UserDTO(String firstName, String secondName, String login, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

}
