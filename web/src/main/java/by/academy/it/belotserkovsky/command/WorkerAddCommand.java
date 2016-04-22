package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.daoServices.WorkerDAOService;
import by.academy.it.belotserkovsky.pojos.Worker;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * add workers information
 * Created by Администратор on 11.04.2016.
 */
public class WorkerAddCommand implements ActionCommand {

    private Worker worker = null;

    private static final String PARAM_NAME_FULL_NAME = "fullName";
    private static final String PARAM_NAME_PROFESSION = "profession";

    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String page = null;
        String fullName = request.getParameter(PARAM_NAME_FULL_NAME);
        String profession = request.getParameter(PARAM_NAME_PROFESSION);

        worker = new Worker();

        worker.setFullName(fullName);
        worker.setProfession(profession);

        WorkerDAOService.getInstance().addWorker(worker);

        page = ConfigurationManager.PATH_PAGE_ADMIN;

        return page;
    }
}