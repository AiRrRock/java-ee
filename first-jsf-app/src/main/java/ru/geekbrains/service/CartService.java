package ru.geekbrains.service;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CartService {

    void addToCart(ProductRepr product);

    void removeFromCart(long id);

    List<ProductRepr> getAllProducts();
}

