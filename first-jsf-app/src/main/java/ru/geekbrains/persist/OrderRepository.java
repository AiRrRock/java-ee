package ru.geekbrains.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.util.List;

@Stateless
public class OrderRepository {

    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager em;



    public List<MyOrder> findAll() {
        return em.createNamedQuery("findAllOrders", MyOrder.class)
                .getResultList();
    }

    public MyOrder findById(Long id) {
        return em.find(MyOrder.class, id);
    }

    public Long countAll() {
        return em.createNamedQuery("countAllOrders", MyOrder.class).getSingleResult().getId();
    }

    public void saveOrUpdate(MyOrder orders) {
        if (orders.getId() == null) {
            em.persist(orders);
        }
        em.merge(orders);
    }

    public void deleteById(Long id) {
        em.createNamedQuery("deleteOrderById")
                .setParameter("id", id)
                .executeUpdate();
    }
}
