package ru.geekbrains.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @EJB
    private OrderRepository orderRepository;

    @Override
    public List<OrderRepr> findAll() {
        return orderRepository.findAll().stream()
                .map(OrderRepr::new)
                .collect(Collectors.toList());
    }

    @Override
    public OrderRepr findById(Long id) {
        MyOrder order = orderRepository.findById(id);
        if (order != null) {
            return new OrderRepr(order);
        }
        return null;
    }

    @Override
    public Long countAll() {
        return orderRepository.countAll();
    }

    @TransactionAttribute
    @Override
    public void saveOrUpdate(OrderRepr order) {
        logger.info("Saving order with id {}" , order.getId());
        List<Product> products = order.getProducts();
        orderRepository.saveOrUpdate(new MyOrder(order));
    }

    @TransactionAttribute
    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
