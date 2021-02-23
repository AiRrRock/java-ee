package ru.geekbrains.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class MenuController {

    public String openProducts(){
        return "/product.xhtml?faces-redirect-true";
    }

    public String openCategories(){
        return "/category.xhtml?faces-redirect-true";
    }

    public String openCart(){
        return "/cart.xhtml?faces-redirect-true";
    }


}
