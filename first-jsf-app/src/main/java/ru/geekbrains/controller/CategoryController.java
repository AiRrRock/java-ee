package ru.geekbrains.controller;

import ru.geekbrains.persist.Category;
import ru.geekbrains.persist.CategoryRepository;
import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CategoryController implements Serializable {

    @Inject
    private CategoryRepository productRepository;

    private Category product;

    public Category getProduct() {
        return product;
    }

    public void setProduct(Category product) {
        this.product = product;
    }

    public String createProduct() {
        this.product = new Category();
        return "/category_form.xhtml?faces-redirect-true";
    }

    public List<Category> getAllProducts() {
        return productRepository.findAll();
    }

    public String editProduct(Category product) {
        this.product = product;
        return "/category_form.xhtml?faces-redirect-true";
    }

    public void deleteProduct(Category product) {
        productRepository.deleteById(product.getId());
    }

    public String saveProduct() {
        productRepository.saveOrUpdate(product);
        return "/category.xhtml?faces-redirect-true";
    }
}
