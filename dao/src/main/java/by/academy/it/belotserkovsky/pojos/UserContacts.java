package by.academy.it.belotserkovsky.pojos;

import org.hibernate.annotations.Cache;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by K.Belotserkovsky
 */

@Entity
@Table(name = "T_USER_CONTACTS")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserContacts implements Serializable {

    private Long userId;
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
    public Long getUserId() {
        return userId;
    }

    @Column(name = "F_ADDRESS")
    public String getAddress() {
        return address;
    }

    @Column(name = "F_PHONE")
    public String getPhone() {
        return phone;
    }

    @Column(name = "F_EMAIL")
    public String getEmail() {
        return email;
    }

    @OneToOne
    @PrimaryKeyJoinColumn
    public User getUser() {
        return user;
    }

    public void setUserId(Long u_id) {
        this.userId = u_id;
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
