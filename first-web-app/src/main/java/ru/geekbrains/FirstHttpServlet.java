package ru.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(urlPatterns = "/http-servlet/*")
public class FirstHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pageHeader", "Servlet Patch Elements");
        getServletContext().getRequestDispatcher("/page_header").include(req, resp);
        resp.getWriter().println("<p>contextPath = " + req.getContextPath() + "</p>");
        resp.getWriter().println("<p>servletPath = " + req.getServletPath() + "</p>");
        resp.getWriter().println("<p>pathInfo = " + req.getPathInfo() + "</p>");
        resp.getWriter().println("<p>queryString = " + req.getQueryString() + "</p>");
        resp.getWriter().println("<p>param1 = " + req.getParameter("param1") + "</p>");
        resp.getWriter().println("<p>param2 = " + req.getParameter("param2") + "</p>");
        resp.getWriter().println("<p>User-Agent Header = " + req.getHeader("User-Agent") + "</p>");

        resp.setHeader("SomeHeader", "value");
        HttpSession session = req.getSession();
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter == null) {
            counter = 1;
        } else {
            counter++;
        }

        session.setAttribute("counter", counter);
        resp.getWriter().println("<p> Счетчик запросов " + counter + "</p>");

        if (Arrays.stream(req.getCookies()).noneMatch(c -> "someCookie".equals(c.getName()))) {
            Cookie cookie = new Cookie("someCookie", "12345");
            resp.addCookie(cookie);
        }
    }
}
