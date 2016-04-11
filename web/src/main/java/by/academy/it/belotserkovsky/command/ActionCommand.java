package by.academy.it.belotserkovsky.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Created by Kostya on 09.04.2016.
 */
public interface ActionCommand {

    String execute(HttpServletRequest request, HttpServletResponse response);
}
