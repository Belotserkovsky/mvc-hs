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

    User user;
    WorkPlan workPlan;

    public Bid(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getbId() {
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

    @ManyToOne
    @JoinColumn(name = "f_workPlan_id")
    public WorkPlan getWorkPlan() {
        return workPlan;
    }


    public void setbId(Long bId) {
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

    public void setWorkPlan(WorkPlan workPlan) {
        this.workPlan = workPlan;
    }
}
