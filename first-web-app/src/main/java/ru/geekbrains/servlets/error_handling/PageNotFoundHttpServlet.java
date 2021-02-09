package ru.geekbrains.servlets.error_handling;

import ru.geekbrains.Pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/not_found")
public class PageNotFoundHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pageHeader", "Error 404. Page is not found");
        getServletContext().getRequestDispatcher("/page_header").include(req, resp);
        resp.getWriter().println("<a href=" + req.getContextPath() + "/" + Pages.Main.getPath() + ">Go to Main page</a>");
    }
}
