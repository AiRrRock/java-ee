package ru.geekbrains.service;


import ru.geekbrains.rest.CategoryServiceRest;

import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateful
public class CartServiceImpl implements CartService {

    private final Map<Long, ProductRepr> productMap = new HashMap<>();

    @Override
    public void addToCart(ProductRepr product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void removeFromCart(long id) {
        productMap.remove(id);
    }

    @Override
    public List<ProductRepr> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }

}
