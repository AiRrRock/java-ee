package ru.geekbrains.persist;

import ru.geekbrains.service.OrderRepr;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "orders")
@NamedQueries({
        @NamedQuery(name = "findAllOrders", query = "from MyOrder "),
        @NamedQuery(name = "countAllOrders", query = "select count(*) from MyOrder where 1 = 1"),
        @NamedQuery(name = "deleteOrderById", query = "delete from MyOrder o where o.id = :id")
})
public class MyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Product> products;

    public MyOrder() {
    }

    public MyOrder(OrderRepr order) {
        this.id = order.getId() ;
        this.products = order.getProducts();
    }

    public MyOrder(Long id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}