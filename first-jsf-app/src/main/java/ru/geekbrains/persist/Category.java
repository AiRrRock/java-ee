package ru.geekbrains.persist;

import ru.geekbrains.service.CategoryRepr;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@NamedQueries({
        @NamedQuery(name = "findAllCategories", query = "from Category"),
        @NamedQuery(name = "countAllCategories", query = "select count(*) from Category"),
        @NamedQuery(name = "deleteCategoryById", query = "delete from Category p where p.id = :id"),
        @NamedQuery(name = "allProductsByCategoryId",
                query = "select p " +
                        "from Product p " +
                        "inner join Category c on p.category.id = c.id " +
                        "where c.id = :id")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "nativeQuery", query = "select * from categories")
})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;


    @Column
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(CategoryRepr category) {
        this.name = category.getName();
        this.id = category.getId();
        this.description = category.getDescription();
        this.products = category.getProductList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
