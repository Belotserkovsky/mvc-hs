package by.academy.it.belotserkovsky.pojos;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by K.Belotserkovsky
 */
@Entity
public class Worker implements Serializable{

    private Long workerId;
    private String fullName;
    private String profession;
    private Set<Brigade> brigades = new HashSet<Brigade>();

    public Worker() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getWorkerId() {
        return workerId;
    }

    @Column
    public String getFullName() {
        return fullName;
    }

    @Column
    public String getProfession() {
        return profession;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "T_WORKER_BRIGADE",
            joinColumns = @JoinColumn(name = "f_worker_id"),
            inverseJoinColumns = @JoinColumn(name = "f_brigade_id"))
    public Set<Brigade> getBrigades() {
        return brigades;
    }

    public void setWorkerId(Long id) {
        this.workerId = id;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
    public void setBrigades(Set<Brigade> brigades) {
        this.brigades = brigades;
    }

}
