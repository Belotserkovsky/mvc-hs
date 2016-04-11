package by.academy.it.belotserkovsky.entity;

/**
 * Created by Kostya on 08.04.2016.
 */
public class Worker {

    private int id;
    private String fullName;
    private String profession;
    private int brigadeId;

    public Worker() {}

    public Worker(int id, String fullName, String profession, int brigadeId) {
        this.id = id;
        this.fullName = fullName;
        this.profession = profession;
        this.brigadeId = brigadeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getBrigadeId() { return brigadeId; }

    public void setBrigadeId(int brigadeId) { this.brigadeId = brigadeId; }
}
