package by.academy.it.belotserkovsky.dto;

/**
 * Created by Kostya on 02.05.2016.
 */
public class BidDTO {

    private Long uid;
    private String kindOfWorks;
    private String scope;
    private String desiredRuntime;
    private String[] selectedWorkers;

    public BidDTO() {
    }

    public BidDTO(Long uid, String kindOfWorks, String scope, String desiredRuntime, String[] selectedWorkers) {
        this.uid = uid;
        this.kindOfWorks = kindOfWorks;
        this.scope = scope;
        this.desiredRuntime = desiredRuntime;
        this.selectedWorkers = selectedWorkers;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
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

    public String[] getSelectedWorkers() {
        return selectedWorkers;
    }

    public void setSelectedWorkers(String[] selectedWorkers) {
        this.selectedWorkers = selectedWorkers;
    }
}
