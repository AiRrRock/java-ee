package ru.geekbrains.controller;

import ru.geekbrains.persist.Category;
import ru.geekbrains.persist.CategoryRepository;
import ru.geekbrains.service.ProductRepr;
import ru.geekbrains.service.ProductService;
import ru.geekbrains.service.RoleRepr;
import ru.geekbrains.service.RoleService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class RoleController implements Serializable {

    @EJB
    private RoleService productService;

    @Inject
    private HttpSession httpSession;

    private RoleRepr product;

    private List<RoleRepr> products;

    private List<Category> categories;

    public void preloadData(ComponentSystemEvent componentSystemEvent) {
        products = productService.getAllRoles();
    }

    public RoleRepr getProduct() {
        return product;
    }

    public void setProduct(RoleRepr product) {
        this.product = product;
    }

    public String createProduct() {
        this.product = new RoleRepr();
        return "/admin/role_form.xhtml?faces-redirect=true";
    }

    public List<RoleRepr> getAllProducts() {
        return products;
    }

    public String editProduct(RoleRepr product) {
        this.product = product;
        return "/admin/role_form.xhtml?faces-redirect=true";
    }


    public String saveProduct() {
        productService.saveOrUpdate(product);
        return "/admin/role.xhtml?faces-redirect=true";
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String logout() {
        //HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpSession.invalidate();
        return "/product.xhtml?faces-redirect=true";
    }
}
