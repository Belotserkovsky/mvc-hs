package by.academy.it.belotserkovsky.pojos;

/**
 * Created by Kostya on 08.04.2016.
 */
public class Worker {

    private Long id;
    private String fullName;
    private String profession;


    public Worker() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;

        Worker worker = (Worker) o;

        if (!id.equals(worker.id)) return false;
        if (!fullName.equals(worker.fullName)) return false;
        return profession.equals(worker.profession);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + profession.hashCode();
        return result;
    }
}
