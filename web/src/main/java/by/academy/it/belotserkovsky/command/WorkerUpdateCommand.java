package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.daoServices.WorkerDAOService;
import by.academy.it.belotserkovsky.pojos.Worker;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * update worker
 * Created by Kostya on 11.04.2016.
 */
public class WorkerUpdateCommand implements ActionCommand {

    private Worker worker = null;

    private static final String PARAM_NAME_ID = "id";
    private static final String PARAM_NAME_FULLNAME = "fullName";
    private static final String PARAM_NAME_PROFESSION = "profession";
    private static final String PARAM_NAME_BRIGADE_ID = "brigade_id";

    public String execute(HttpServletRequest request, HttpServletResponse response) {

//        String page = null;
//        String w_id = request.getParameter(PARAM_NAME_ID);
//        String fullName = request.getParameter(PARAM_NAME_FULLNAME);
//        String profession = request.getParameter(PARAM_NAME_PROFESSION);
//        String brigadeId = request.getParameter(PARAM_NAME_BRIGADE_ID);
//
//        worker = new Worker();
//
//        worker.setId(Integer.parseInt(w_id));
//        worker.setFullName(fullName);
//        worker.setProfession(profession);
//        worker.setBrigadeId(Integer.parseInt(brigadeId));
//
//        WorkerDAOService.getInstance().updateWorker(worker);
//
        return ConfigurationManager.PATH_PAGE_ADMIN;

    }
}
