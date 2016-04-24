package by.academy.it.belotserkovsky.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by Kostya on 22.04.2016.
 */
public class WorkPlan implements Serializable{

    private Long id;
    private String title;
    private Date date;

    private Set<Bid> bids;
    private Set<Brigade> brigades;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    public Set<Brigade> getBrigades() {
        return brigades;
    }

    public void setBrigades(Set<Brigade> brigades) {
        this.brigades = brigades;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
