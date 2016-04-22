package by.academy.it.belotserkovsky.pojos;

/**
 * Created by Kostya on 08.04.2016.
 */
public class Bid {

    private Long id;
    private String kindOfWorks;
    private String scope;
    private String desiredRuntime;

    User user;
    WorkPlan workPlan;

    public Bid(){}

}
