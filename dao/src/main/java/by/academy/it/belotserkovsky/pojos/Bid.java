package by.academy.it.belotserkovsky.pojos;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Kostya on 08.04.2016.
 */

@Entity
public class Bid implements Serializable{

    private Long bId;
    private String kindOfWorks;
    private String scope;
    private String desiredRuntime;

    private User user;
    private Brigade brigade;

    public Bid(){}

    public Bid(String kindOfWorks, String scope, String desiredRuntime, Brigade brigade) {
        this.kindOfWorks = kindOfWorks;
        this.scope = scope;
        this.desiredRuntime = desiredRuntime;
        this.brigade = brigade;
    }

    public Bid(String kindOfWorks, String scope, String desiredRuntime) {
        this.kindOfWorks = kindOfWorks;
        this.scope = scope;
        this.desiredRuntime = desiredRuntime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getBId() {
        return bId;
    }

    @Column
    public String getKindOfWorks() {
        return kindOfWorks;
    }

    @Column
    public String getScope() {
        return scope;
    }

    @Column
    public String getDesiredRuntime() {
        return desiredRuntime;
    }

    @ManyToOne
    @JoinColumn(name = "f_user_id")
    public User getUser() {
        return user;
    }

    @OneToOne(mappedBy = "bid", cascade = CascadeType.ALL)
    public Brigade getBrigade() {
        return brigade;
    }

    public void setBId(Long bId) {
        this.bId = bId;
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

    public void setUser(User user) {
        this.user = user;
    }

    public void setBrigade(Brigade brigade) {
        this.brigade = brigade;
    }

}
