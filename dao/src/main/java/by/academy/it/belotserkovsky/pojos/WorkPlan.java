package by.academy.it.belotserkovsky.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by Kostya on 22.04.2016.
 */

@Entity
public class WorkPlan implements Serializable{

    private Long wpid;
    private String title;
    private Date date;
    private Set<Bid> bids;
    private Set<Brigade> brigades;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getWpid() {
        return wpid;
    }

    @Column
    public String getTitle() {
        return title;
    }

    @OneToMany(mappedBy = "workPlan")
    public Set<Bid> getBids() {
        return bids;
    }

    @OneToMany(mappedBy = "workPlan")
    public Set<Brigade> getBrigades() {
        return brigades;
    }

    @Column()
    public Date getDate() {
        return date;
    }

    public void setWpid(Long wpid) {
        this.wpid = wpid;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }
    public void setBrigades(Set<Brigade> brigades) {
        this.brigades = brigades;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
