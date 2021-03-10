package ru.geekbrains.controller;

import ru.geekbrains.persist.Category;
import ru.geekbrains.service.CategoryRepr;
import ru.geekbrains.service.CategoryService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CategoryController implements Serializable {

    @EJB
    private CategoryService categoryService;

    private CategoryRepr product;

    public CategoryRepr getProduct() {
        return product;
    }

    public void setProduct(CategoryRepr product) {
        this.product = product;
    }

    public String createProduct() {
        this.product = new CategoryRepr();
        return "/category_form.xhtml?faces-redirect-true";
    }

    public List<CategoryRepr> getAllProducts() {
        return categoryService.findAll();
    }

    public String editProduct(CategoryRepr product) {
        this.product = product;
        return "/category_form.xhtml?faces-redirect-true";
    }

    public void deleteProduct(CategoryRepr product) {
        categoryService.deleteById(product.getId());
    }

    public String saveProduct() {
        categoryService.saveOrUpdate(product);
        return "/category.xhtml?faces-redirect-true";
    }
}
