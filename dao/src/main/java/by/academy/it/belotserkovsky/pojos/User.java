package by.academy.it.belotserkovsky.pojos;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kostya on 08.04.2016.
 */

@Entity
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User implements Serializable{
    private Long userId;
    private String firstName;
    private String secondName;
    private String login;
    private String password;
    private UserContacts userContacts;
    private Set<Bid> bids = new HashSet<Bid>();

    public User() {}

    public User(String firstName, String secondName, String login, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
    }

    public User(Long u_id, String firstName, String secondName, String login, String password) {
        this.userId = u_id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getUserId() {
        return userId;
    }

    @Column
    public String getFirstName() {
        return firstName;
    }

    @Column
    public String getSecondName() {
        return secondName;
    }

    @Column
    public String getLogin() {
        return login;
    }

    @Column
    public String getPassword() {
        return password;
    }

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    public UserContacts getUserContacts() {
        return userContacts;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public Set<Bid> getBids() {
        return bids;
    }


    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserContacts(UserContacts userContacts) {
        this.userContacts = userContacts;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }
}
