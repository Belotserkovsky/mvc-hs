package by.academy.it.belotserkovsky.pojos;

import org.hibernate.annotations.OnDelete;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kostya on 08.04.2016.
 */
@Entity
public class Worker implements Serializable{

    private Long wid;
    private String fullName;
    private String profession;
    private Set<Brigade> brigades = new HashSet<Brigade>();

    public Worker() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getWid() {
        return wid;
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


    public void setWid(Long wid) {
        this.wid = wid;
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
