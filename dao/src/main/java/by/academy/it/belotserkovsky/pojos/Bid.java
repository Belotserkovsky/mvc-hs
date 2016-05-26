package by.academy.it.belotserkovsky.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by K.Belotserkovsky
 */

@Entity
@Table(name = "T_BID")
public class Bid implements Serializable{

    private Long id;
    private String kindOfWorks;
    private String scope;
    private String desiredRuntime;
    private Date creationDate;
    private String status;

    private User user;
    private Brigade brigade;

    public Bid(){}

    public Bid(String kindOfWorks, String scope, String desiredRuntime, Date currentDate, String status) {
        this.kindOfWorks = kindOfWorks;
        this.scope = scope;
        this.desiredRuntime = desiredRuntime;
        this.creationDate = currentDate;
        this.status = status;
    }

    @Id
    @Column(name = "F_BID_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Column(name = "F_KIND_OF_WORKS")
    public String getKindOfWorks() {
        return kindOfWorks;
    }

    @Column(name = "F_SCOPE")
    public String getScope() {
        return scope;
    }

    @Column(name = "F_DESIRED_RUNTIME")
    public String getDesiredRuntime() {
        return desiredRuntime;
    }

    @Column(name = "F_CREATION_DATE")
    public Date getCreationDate() {
        return creationDate;
    }

    @Column(name = "F_STATUS")
    public String getStatus() {
        return status;
    }

    @ManyToOne
    @JoinColumn(name = "F_USER_ID")
    public User getUser() {
        return user;
    }

    @OneToOne(mappedBy = "bid", cascade = CascadeType.ALL)
    public Brigade getBrigade() {
        return brigade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKindOfWorks(String kindOfWorks) {
        this.kindOfWorks = kindOfWorks;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setDesiredRuntime(String desiredRuntime) {
        this.desiredRuntime = desiredRuntime;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBrigade(Brigade brigade) {
        this.brigade = brigade;
    }

}
