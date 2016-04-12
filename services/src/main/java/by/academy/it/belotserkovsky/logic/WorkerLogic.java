package by.academy.it.belotserkovsky.logic;

/**
 * comparing the selected workers with workers from data base
 * Created by Администратор on 12.04.2016.
 */
public class WorkerLogic {

    private static WorkerLogic instance;

    private final static String PARAM_FULLNAME= "fullName";
    private final static String PARAM_PROFESSION = "profession";
    private final static String PARAM_BRIGADE_ID = "brigade_id";

    private WorkerLogic() {
        super();
    }

    public static WorkerLogic getInstance() {
        if (instance == null) {
            instance = new WorkerLogic();
        }
        return instance;
    }

    public void compaeWorkers (String[] selected){
        
    }
}
