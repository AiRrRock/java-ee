package ru.geekbrains.servlets.auxiliary;

import ru.geekbrains.Pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/page_menu")
public class PageMenuHttpServlet extends HttpServlet {
    public static final String ANCHOR_FORMAT = "<a href=%s/%s>%s</a>";
    public static final String ACTIVE_ANCHOR_FORMAT = "<a class=\"active\" href=%s/%s>%s</a>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();
        PrintWriter writer = resp.getWriter();
        Pages activePage = (Pages) req.getAttribute("activePage");

        //first-web-app/src/main/webapp

        String cssTag = "<link rel='stylesheet' type='text/css' href='" + req.getContextPath() + "/css/styles.css'>";
        writer.println("<html><head>" + cssTag + "</head>");
        writer.println("<div class=\"topnav\">");
        for (Pages page : Pages.values()) {
            if (activePage.equals(page)) {
                writer.println(String.format(ACTIVE_ANCHOR_FORMAT, contextPath, page.getPath(), page.getHeading()));
            } else {
                writer.println(String.format(ANCHOR_FORMAT, contextPath, page.getPath(), page.getHeading()));
            }
        }
        writer.println("</div>");
    }
}
