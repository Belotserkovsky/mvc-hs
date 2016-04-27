package by.academy.it.belotserkovsky.pojos;

import java.io.Serializable;

/**
 * Created by Kostya on 23.04.2016.
 */
public class UserContacts implements Serializable {

    private Long id;
    private String address;
    private String phone;
    private String email;

    private User user;

    public UserContacts() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
