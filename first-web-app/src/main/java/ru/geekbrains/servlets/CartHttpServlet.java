package ru.geekbrains.servlets;


import ru.geekbrains.Pages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/cart")
public class CartHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pageHeader", Pages.Cart.getHeading());
        req.setAttribute("activePage", Pages.Cart);
        getServletContext().getRequestDispatcher("/page_menu").include(req, resp);
        getServletContext().getRequestDispatcher("/page_header").include(req, resp);
    }
}
