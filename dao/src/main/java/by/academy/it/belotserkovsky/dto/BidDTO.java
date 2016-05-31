package by.academy.it.belotserkovsky.dto;

import java.sql.Date;

/**
 * Created by K.Belotserkovsky
 */
public class BidDto {

    private Long userId;
    private String userName;
    private Long bidId;
    private String kindOfWorks;
    private String scope;
    private String desiredRuntime;
    private String brigadeTitle;
    private Date creationDate;
    private String status;

    public BidDto() {
    }

    public BidDto(String userName, String scope, String desiredRuntime) {
        this.userName = userName;
        this.scope = scope;
        this.desiredRuntime = desiredRuntime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getBidId() {
        return bidId;
    }

    public void setBidId(Long bidId) {
        this.bidId = bidId;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
