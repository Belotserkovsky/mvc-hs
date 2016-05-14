package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.daoServices.WorkerService;
import by.academy.it.belotserkovsky.pojos.Worker;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * return the list of available workers
 * Created by Kostya on 11.04.2016.
 */
public class WorkersListCommand implements ActionCommand {

    public String execute(HttpServletRequest request, HttpServletResponse response) {


        List<Worker> list = WorkerService.getInstance().getWorkersList();

        request.setAttribute("workersList", list);

        return ConfigurationManager.PATH_PAGE_WORKERSLIST;
    }
}


