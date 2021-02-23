package ru.geekbrains.persist;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Named
@ApplicationScoped
public class CategoryRepository {

    private final Map<Long, Category> categoryMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {

        this.saveOrUpdate(new Category(null, "Category 1", "Category description 1"));
        this.saveOrUpdate(new Category(null, "Category 2", "Category description 2"));
        this.saveOrUpdate(new Category(null, "Category 3", "Category description 3"));
        this.saveOrUpdate(new Category(null, "Category 4", "Category description 4"));

    }

    private final AtomicLong identity = new AtomicLong();

    public List<Category> findAll() {
        return new ArrayList<>(categoryMap.values());
    }

    public Category findById(Long id) {
        return categoryMap.get(id);
    }

    public void saveOrUpdate(Category category) {
        if (category.getId() == null) {
            Long id = identity.incrementAndGet();
            category.setId(id);
        }
        categoryMap.put(category.getId(), category);
    }

    public void deleteById(Long id) {
        categoryMap.remove(id);
    }
}
