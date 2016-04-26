package by.academy.it.belotserkovsky.filter;

import by.academy.it.belotserkovsky.command.constants.UserType;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * filters address to the servlet from any source
 * Created by Kostya on 09.04.2016.
 */

@WebFilter(urlPatterns = { "/*" })
public class SecurityFilter implements Filter{

    public void destroy() {
    }
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        UserType type = (UserType) session.getAttribute("userType");
        if (type == null) {
            type = UserType.GUEST;
            session.setAttribute("userType", type);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
        }
        chain.doFilter(request, response);
    }
    public void init(FilterConfig fConfig) throws ServletException {
    }
}
