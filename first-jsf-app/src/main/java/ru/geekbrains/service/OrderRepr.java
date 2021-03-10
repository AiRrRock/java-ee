package ru.geekbrains.service;

import ru.geekbrains.persist.MyOrder;
import ru.geekbrains.persist.Product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

// DTO
public class OrderRepr implements Serializable {

    private Long id;

    private List<Product> products;

    public OrderRepr() {
    }

    public OrderRepr(MyOrder order) {
        id = order.getId();
        products = order.getProducts();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
