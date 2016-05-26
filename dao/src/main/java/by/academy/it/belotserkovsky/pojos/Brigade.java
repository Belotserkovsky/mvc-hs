package by.academy.it.belotserkovsky.pojos;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kostya on 08.04.2016.
 */

@Entity
@Table(name = "T_BRIGADE")
public class Brigade implements Serializable{

    private Long id;
    private String title;
    private Bid bid;
    private Set<Worker> workers = new HashSet<Worker>();

    public Brigade() { }

    public Brigade(String title) {
        this.title = title;
    }

    @Id
    @Column(name = "F_BRIGADE_ID")
    @GenericGenerator(name = "gen2",
            strategy = "foreign",
            parameters = @Parameter(name = "property", value = "bid")
    )
    @GeneratedValue(generator = "gen2")
    public Long getId() {
        return id;
    }

    @Column(name = "F_TITLE")
    public String getTitle() {
        return title;
    }

    @ManyToMany(mappedBy = "brigades")
    public Set<Worker> getWorkers() {
        return workers;
    }

    @OneToOne
    @PrimaryKeyJoinColumn
    public Bid getBid() {
        return bid;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }
    public void setBid(Bid bid) {
        this.bid = bid;
    }
}
