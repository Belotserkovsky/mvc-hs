package by.academy.it.belotserkovsky.command;

import by.academy.it.belotserkovsky.daoServices.UserService;
import by.academy.it.belotserkovsky.dto.UserDto;
import by.academy.it.belotserkovsky.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Kostya on 09.05.2016.
 */
public class UsersListCommand implements ActionCommand {
    String page = null;

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int page = 1;
        int recordsPerPage = 3;
        if(request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int allRecords = UserService.getInstance().getRowsUsers();
//        List<UserDto> list = UserService.getInstance().getAllUsers((page-1)*recordsPerPage, recordsPerPage);
        int numberOfPages = (int) Math.ceil((double)allRecords / recordsPerPage);
//        request.setAttribute("usersList", list);
        request.setAttribute("numberOfPages", numberOfPages);
        request.setAttribute("currentPage", page);

        return ConfigurationManager.PATH_PAGE_USERS_LIST;
    }
}
