package by.academy.it.belotserkovsky.command.factory;

import by.academy.it.belotserkovsky.command.ActionCommand;
import by.academy.it.belotserkovsky.command.constants.CommandEnum;
import by.academy.it.belotserkovsky.command.EmptyCommand;
import by.academy.it.belotserkovsky.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Kostya 
 * 1) извлечение имени команды из запроса
 * 2) получение объекта, соответствующего команде
 */
public class ActionFactory {
	public ActionCommand defineCommand(HttpServletRequest request, HttpServletResponse response) {
		ActionCommand current = new EmptyCommand();
		String action = request.getParameter("command");
		if (action == null || action.length() == 0) {
			// если команда не задана в текущем запросе
			return current;
		}
		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute("wrongAction", action + MessageManager.MESSAGE_WRONG_ACTION);
		}
		return current;
	}
}
