package by.academy.it.belotserkovsky.pojos;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;
import org.jboss.logging.annotations.Property;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by Kostya on 23.04.2016.
 */

@Entity
public class UserContacts implements Serializable {

    private Long uid;
    private String address;
    private String phone;
    private String email;

    private User user;

    public UserContacts() {
    }

    public UserContacts(String address, String phone, String email) {
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    @Id
    @GenericGenerator(name = "gen1",
            strategy = "foreign",
            parameters = @Parameter(name = "property", value = "user")
    )
    @GeneratedValue(generator = "gen1")
    public Long getUid() {
        return uid;
    }

    @Column
    public String getAddress() {
        return address;
    }

    @Column
    public String getPhone() {
        return phone;
    }

    @Column
    public String getEmail() {
        return email;
    }

    @OneToOne
    @PrimaryKeyJoinColumn
    public User getUser() {
        return user;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
