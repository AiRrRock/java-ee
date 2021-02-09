package ru.geekbrains.servlets.error_handling;

import ru.geekbrains.Pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/forbidden")
public class ForbiddenHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pageHeader", "Access denied error 403");
        getServletContext().getRequestDispatcher("/page_header").include(req, resp);
        resp.getWriter().println("<a href=" + req.getContextPath() + "/" + Pages.Main.getPath() + ">Go to Main page</a>");
    }
}
