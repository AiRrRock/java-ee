package ru.geekbrains.controller;

import ru.geekbrains.persist.Product;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Named
@SessionScoped
public class CartController implements Serializable {

    private Set<Product> productMap = new HashSet<>();
    private AtomicLong current = new AtomicLong(0);

    public String addToCart(Product product) {
        productMap.add(product);
        return "/product.xhtml?faces-redirect-true";
    }

    public Collection<Product> getAllProducts() {
        return productMap;
    }

    public String removeFromCart(Product product) {
        productMap.remove(product);
        if (productMap.isEmpty()) {
            return "/product.xhtml?faces-redirect-true";
        }
        return "/cart.xhtml?faces-redirect-true";
    }
}
