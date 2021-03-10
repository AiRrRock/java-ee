package ru.geekbrains.service;

import javax.ejb.Local;
import java.util.List;

@Local
public interface OrderService {

    List<OrderRepr> findAll();

    OrderRepr findById(Long id);

    Long countAll();

    void saveOrUpdate(OrderRepr product);

    void deleteById(Long id);
}
