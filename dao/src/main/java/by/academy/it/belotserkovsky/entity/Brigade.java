package by.academy.it.belotserkovsky.entity;

/**
 * Created by Kostya on 08.04.2016.
 */
public class Brigade {

    private int id;
    private String name;

    public Brigade() { }

    public Brigade(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
