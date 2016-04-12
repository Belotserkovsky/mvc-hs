package by.academy.it.belotserkovsky.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * command to select a worker
 * Created by Администратор on 12.04.2016.
 */
public class ChoiceWorkerCommand implements ActionCommand{

    private static final String PARAM_NAME_WORKERS = "workers";

    public String execute(HttpServletRequest request, HttpServletResponse response){

        String page = null;

        String[] selected= request.getParameterValues(PARAM_NAME_WORKERS);



        return page;
    }
}
