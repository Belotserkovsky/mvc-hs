package by.academy.it.belotserkovsky.entity;

/**
 * Created by Kostya on 08.04.2016.
 */
public class Bid {
    int id;
    String kindOfWorks;
    String scope;
    String desiredRuntime;
    int userId;
    int brigadeId;

    public Bid(){}

    public Bid(int id, String kindOfWorks, String scope, String desiredRuntime, int clientId, int brigadeId) {
        super();
        this.id = id;
        this.kindOfWorks = kindOfWorks;
        this.scope = scope;
        this.desiredRuntime = desiredRuntime;
        this.userId = clientId;
        this.brigadeId = brigadeId;
    }

    public Bid(String kindOfWorks, String scope, String desiredRuntime, int userId, int brigadeId) {
        super();
        this.kindOfWorks = kindOfWorks;
        this.scope = scope;
        this.desiredRuntime = desiredRuntime;
        this.userId = userId;
        this.brigadeId = brigadeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBrigadeId() {
        return brigadeId;
    }

    public void setBrigadeId(int brigadeId) {
        this.brigadeId = brigadeId;
    }
}
