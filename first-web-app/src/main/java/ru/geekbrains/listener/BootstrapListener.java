package ru.geekbrains.listener;

import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;

@WebListener
public class BootstrapListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductRepository productRepository = new ProductRepository();

        productRepository.saveOrUpdate(new Product(null, "Product 1",
                "Product 1 description", new BigDecimal(1001)));
        productRepository.saveOrUpdate(new Product(null, "Product 2",
                "Product 2 description", new BigDecimal(1002)));
        productRepository.saveOrUpdate(new Product(null, "Product 3",
                "Product 3 description", new BigDecimal(1030)));
        productRepository.saveOrUpdate(new Product(null, "Product 4",
                "Product 4 description", new BigDecimal(1200)));
        productRepository.saveOrUpdate(new Product(null, "Product 5",
                "Product 5 description", new BigDecimal(1000)));

        sce.getServletContext().setAttribute("productRepository", productRepository);
    }
}
