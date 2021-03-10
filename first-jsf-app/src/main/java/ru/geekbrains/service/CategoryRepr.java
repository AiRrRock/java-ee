package ru.geekbrains.service;

import ru.geekbrains.persist.Category;
import ru.geekbrains.persist.Product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

// DTO
public class CategoryRepr implements Serializable {

    private Long id;

    private String name;

    private String description;

    private List<Product> productList;

    public CategoryRepr() {
    }

    public CategoryRepr(Category category) {
        id = category.getId();
        name = category.getName();
        productList = category.getProducts();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
