package by.academy.it.belotserkovsky.pojos;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by K.Belotserkovsky
 */

@Entity
@Table(name = "T_USER")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User implements Serializable{
    private Long userId;
    private String firstName;
    private String secondName;
    private String userName;
    private String password;
    private String role;
    private UserContacts userContacts;
    private Set<Bid> bids = new HashSet<Bid>();

    public User() {}

    public User(String firstName, String secondName, String login, String password, String role) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.userName = login;
        this.password = password;
        this.role = role;
    }

    public User(Long u_id, String firstName, String secondName, String login, String password) {
        this.userId = u_id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.userName = login;
        this.password = password;
    }

    @Id
    @Column(name = "F_USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getUserId() {
        return userId;
    }

    @Column(name = "F_FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "F_SECOND_NAME")
    public String getSecondName() {
        return secondName;
    }

    @Column(name = "F_USER_NAME", unique = true)
    public String getUserName() {
        return userName;
    }

    @Column(name = "F_PASSWORD", nullable = false)
    public String getPassword() {
        return password;
    }

    @Column(name = "F_ROLE")
    public String getRole() {
        return role;
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUserContacts(UserContacts userContacts) {
        this.userContacts = userContacts;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }
}
