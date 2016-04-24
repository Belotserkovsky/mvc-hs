package by.academy.it.belotserkovsky.pojos;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Kostya on 08.04.2016.
 */
public class User implements Serializable{
    private Long id;
    private String firstName;
    private String secondName;
    private String login;
    private String password;

    private UserContacts userContacts;
    private Set<Bid> bids;

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    public UserContacts getUserContacts() {
        return userContacts;
    }

    public void setUserContacts(UserContacts userContacts) {
        this.userContacts = userContacts;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof User)) return false;
//
//        User user = (User) o;
//
//        if (!id.equals(user.id)) return false;
//        if (!firstName.equals(user.firstName)) return false;
//        if (!secondName.equals(user.secondName)) return false;
//        if (!login.equals(user.login)) return false;
//        if (!password.equals(user.password)) return false;
//        if (!userContacts.equals(user.userContacts)) return false;
//        return bids.equals(user.bids);
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id.hashCode();
//        result = 31 * result + firstName.hashCode();
//        result = 31 * result + secondName.hashCode();
//        result = 31 * result + login.hashCode();
//        result = 31 * result + password.hashCode();
//        result = 31 * result + userContacts.hashCode();
//        result = 31 * result + bids.hashCode();
//        return result;
//    }
}
