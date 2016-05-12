package by.academy.it.belotserkovsky.dto;

import by.academy.it.belotserkovsky.pojos.Brigade;

/**
 * Created by K.Belotserkovsky
 */
public class BidDTO {

    private Long uid;
    private Long bId;
    private String kindOfWorks;
    private String scope;
    private String desiredRuntime;
    private String brigadeTitle;

    public BidDTO() {
    }

    public BidDTO(String kindOfWorks, String scope, String desiredRuntime, String brigadeTitle) {
        this.kindOfWorks = kindOfWorks;
        this.scope = scope;
        this.desiredRuntime = desiredRuntime;
        this.brigadeTitle = brigadeTitle;
    }

    public BidDTO(Long uid, String kindOfWorks, String scope, String desiredRuntime) {
        this.uid = uid;
        this.kindOfWorks = kindOfWorks;
        this.scope = scope;
        this.desiredRuntime = desiredRuntime;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getbId() {
        return bId;
    }

    public void setbId(Long bId) {
        this.bId = bId;
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

    public String getBrigadeTitle() {
        return brigadeTitle;
    }

    public void setBrigadeTitle(String brigadeTitle) {
        this.brigadeTitle = brigadeTitle;
    }
}
