package by.academy.it.belotserkovsky.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by K.Belotserkovsky
 */
@Entity
@Table(name = "T_WORKER")
public class Worker implements Serializable{

    private Long workerId;
    private String fullName;
    private String profession;
    private Set<Brigade> brigades = new HashSet<Brigade>();

    public Worker() {}

    @Id
    @Column(name = "F_WORKER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getWorkerId() {
        return workerId;
    }

    @Column(name = "F_FULL_NAME")
    public String getFullName() {
        return fullName;
    }

    @Column(name = "F_PROFESSION")
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
