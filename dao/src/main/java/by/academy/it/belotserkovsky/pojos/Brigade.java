package by.academy.it.belotserkovsky.pojos;

/**
 * Created by Kostya on 08.04.2016.
 */
public class Brigade {

    private Long id;
    private String name;

    private WorkPlan workPlan;

    public Brigade() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkPlan getWorkPlan() {
        return workPlan;
    }

    public void setWorkPlan(WorkPlan workPlan) {
        this.workPlan = workPlan;
    }


}
