package by.academy.it.belotserkovsky.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kostya on 08.04.2016.
 */

@Entity
public class Brigade implements Serializable{

    private Long brId;
    private String title;
    private WorkPlan workPlan;
    private Set<Worker> workers = new HashSet<Worker>();

    public Brigade() { }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getBrId() {
        return brId;
    }

    @Column
    public String getTitle() {
        return title;
    }

    @ManyToOne
    @JoinColumn(name = "f_workPlan_id")
    public WorkPlan getWorkPlan() {
        return workPlan;
    }

    @ManyToMany(mappedBy = "brigades")
    public Set<Worker> getWorkers() {
        return workers;
    }

    public void setBrId(Long brId) {
        this.brId = brId;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setWorkPlan(WorkPlan workPlan) {
        this.workPlan = workPlan;
    }
    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }
}
