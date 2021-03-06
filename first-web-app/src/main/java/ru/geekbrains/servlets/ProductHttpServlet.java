package ru.geekbrains.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.Pages;
import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(urlPatterns = "/product/*")
public class ProductHttpServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        this.productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");
        if (productRepository == null) {
            throw new ServletException("ProductRepository is not initialized");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pageHeader", Pages.Product.getHeading());
        req.setAttribute("activePage", Pages.Product);
        req.setAttribute("products", productRepository.findAll());
        getServletContext().getRequestDispatcher("/page_menu").include(req, resp);
        getServletContext().getRequestDispatcher("/page_header").include(req, resp);
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || "/".equals(pathInfo)) {
            getServletContext().getRequestDispatcher("/WEB-INF/product.jsp").include(req, resp);
        } else if ("/edit".equals(pathInfo)) {
            long id;
            try {
                id = Long.parseLong(req.getParameter("id"));
            } catch (NumberFormatException e) {
                resp.setStatus(400);
                return;
            }
            Product product = productRepository.findById(id);
            if (product == null) {
                resp.setStatus(404);
                return;
            }
            req.setAttribute("product", product);
            getServletContext().getRequestDispatcher("/WEB-INF/product_form.jsp").include(req, resp);
        } else if ("/create".equals(pathInfo)) {
            Product product = new Product(null, null, null, null);
            req.setAttribute("product", product);
            getServletContext().getRequestDispatcher("/WEB-INF/product_form.jsp").include(req, resp);
        } else if ("/delete".equals(pathInfo)) {
            long id;
            try {
                id = Long.parseLong(req.getParameter("id"));
            } catch (NumberFormatException e) {
                resp.setStatus(400);
                return;
            }
            productRepository.deleteById(id);
            resp.sendRedirect(getServletContext().getContextPath() + "/product");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id;
        String idString = req.getParameter("id");
        BigDecimal price;
        try {
            if (idString == null || idString.isEmpty()) {
                id = null;
            } else {
                id = Long.parseLong(req.getParameter("id"));
            }
            price = new BigDecimal(req.getParameter("price"));
        } catch (NumberFormatException e) {
            resp.setStatus(400);
            return;
        }
        Product product = new Product(id, req.getParameter("name"), req.getParameter("description"), price);
        productRepository.saveOrUpdate(product);
        resp.sendRedirect(getServletContext().getContextPath() + "/product");
    }
}
