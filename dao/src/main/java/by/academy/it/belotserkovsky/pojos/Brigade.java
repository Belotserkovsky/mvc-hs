package by.academy.it.belotserkovsky.pojos;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kostya on 08.04.2016.
 */

@Entity
public class Brigade implements Serializable{

    private Long bId;
    private String title;
    private Bid bid;
//    private WorkPlan workPlan;
    private Set<Worker> workers = new HashSet<Worker>();

    public Brigade() { }

    public Brigade(String title) {
        this.title = title;
    }

    @Id
    @GenericGenerator(name = "gen2",
            strategy = "foreign",
            parameters = @Parameter(name = "property", value = "bid")
    )
    @GeneratedValue(generator = "gen2")
    public Long getbId() {
        return bId;
    }

    @Column
    public String getTitle() {
        return title;
    }

//    @ManyToOne
//    @JoinColumn(name = "f_workPlan_id")
//    public WorkPlan getWorkPlan() {
//        return workPlan;
//    }

    @ManyToMany(mappedBy = "brigades")
    public Set<Worker> getWorkers() {
        return workers;
    }

    @OneToOne
    @PrimaryKeyJoinColumn
    public Bid getBid() {
        return bid;
    }

    public void setbId(Long brId) {
        this.bId = bId;
    }
    public void setTitle(String title) {
        this.title = title;
    }

//    public void setWorkPlan(WorkPlan workPlan) {
//        this.workPlan = workPlan;
//    }

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }
}
