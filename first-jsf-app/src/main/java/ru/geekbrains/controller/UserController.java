package ru.geekbrains.controller;

import ru.geekbrains.persist.Category;
import ru.geekbrains.persist.Role;
import ru.geekbrains.service.RoleRepr;
import ru.geekbrains.service.RoleService;
import ru.geekbrains.service.UserRepr;
import ru.geekbrains.service.UserService;

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
public class UserController implements Serializable {

    @EJB
    private UserService productService;


    @EJB
    private RoleService roleService;

    @Inject
    private HttpSession httpSession;

    private UserRepr product;

    private List<UserRepr> products;
    private List<RoleRepr> roles;

    public void preloadData(ComponentSystemEvent componentSystemEvent) {
        products = productService.getAllUsers();
        roles  = roleService.getAllRoles();
    }

    public UserRepr getProduct() {
        return product;
    }

    public void setProduct(UserRepr product) {
        this.product = product;
    }

    public String createProduct() {
        this.product = new UserRepr();
        return "/admin/user_form.xhtml?faces-redirect=true";
    }

    public List<UserRepr> getAllProducts() {
        return products;
    }

    public String editProduct(UserRepr product) {
        this.product = product;
        return "/admin/user_form.xhtml?faces-redirect=true";
    }

    public String saveProduct() {
        productService.saveOrUpdate(product);
        return "/admin/user.xhtml?faces-redirect=true";
    }

    public List<RoleRepr> getCategories() {
        return roles ;
    }

    public void setCategories(List<RoleRepr> categories) {
        this.roles = categories;
    }

    public String logout() {
        //HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpSession.invalidate();
        return "/product.xhtml?faces-redirect=true";
    }
}
