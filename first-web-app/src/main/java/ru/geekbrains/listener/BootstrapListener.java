package ru.geekbrains.listener;

import ru.geekbrains.persist.*;

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


        CategoryRepository categoryRepository = new CategoryRepository();
        categoryRepository.saveOrUpdate(new Category(null, "Category 1", "Category description 1"));
        categoryRepository.saveOrUpdate(new Category(null, "Category 2", "Category description 2"));
        categoryRepository.saveOrUpdate(new Category(null, "Category 3", "Category description 3"));
        categoryRepository.saveOrUpdate(new Category(null, "Category 4", "Category description 4"));

        UserRepository userRepository = new UserRepository();
        userRepository.saveOrUpdate(new User(null, "user1", "user1@users.com"));
        userRepository.saveOrUpdate(new User(null, "user2", "user2@users.com"));
        userRepository.saveOrUpdate(new User(null, "user3", "user3@users.com"));
        userRepository.saveOrUpdate(new User(null, "user4", "user4@users.com"));

        sce.getServletContext().setAttribute("productRepository", productRepository);
        sce.getServletContext().setAttribute("categoryRepository", categoryRepository);
        sce.getServletContext().setAttribute("userRepository", userRepository);

    }
}
