package by.academy.it.belotserkovsky.pojos;

import java.io.Serializable;

/**
 * Created by Kostya on 08.04.2016.
 */
public class Bid implements Serializable{

    private Long id;
    private String kindOfWorks;
    private String scope;
    private String desiredRuntime;

    User user;
    WorkPlan workPlan;

    public Bid(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKindOfWorks() {
        return kindOfWorks;
    }

    public void setKindOfWorks(String kindOfWorks) {
        this.kindOfWorks = kindOfWorks;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getDesiredRuntime() {
        return desiredRuntime;
    }

    public void setDesiredRuntime(String desiredRuntime) {
        this.desiredRuntime = desiredRuntime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WorkPlan getWorkPlan() {
        return workPlan;
    }

    public void setWorkPlan(WorkPlan workPlan) {
        this.workPlan = workPlan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bid)) return false;

        Bid bid = (Bid) o;

        if (!id.equals(bid.id)) return false;
        if (!kindOfWorks.equals(bid.kindOfWorks)) return false;
        if (!scope.equals(bid.scope)) return false;
        if (!desiredRuntime.equals(bid.desiredRuntime)) return false;
        if (user != null ? !user.equals(bid.user) : bid.user != null) return false;
        return workPlan != null ? workPlan.equals(bid.workPlan) : bid.workPlan == null;

    }

//    @Override
//    public int hashCode() {
//        int result = id.hashCode();
//        result = 31 * result + kindOfWorks.hashCode();
//        result = 31 * result + scope.hashCode();
//        result = 31 * result + desiredRuntime.hashCode();
//        result = 31 * result + (user != null ? user.hashCode() : 0);
//        result = 31 * result + (workPlan != null ? workPlan.hashCode() : 0);
//        return result;
//    }

}
