package ru.geekbrains.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.Category;
import ru.geekbrains.persist.CategoryRepository;
import ru.geekbrains.rest.CategoryServiceRest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class CategoryServiceImpl implements CategoryService, CategoryServiceRest {

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @EJB
    private CategoryRepository categoryRepository;


    @Override
    public List<CategoryRepr> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryRepr::new)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryRepr findById(Long id) {
        Category category = categoryRepository.findById(id);
        if (category != null) {
            return new CategoryRepr(category);
        }
        return null;
    }

    @Override
    public Long countAll() {
        return categoryRepository.countAll();
    }

    @Override
    public void insert(CategoryRepr category) {
        if (category.getId() != null) {
            throw new IllegalArgumentException();
        }
        saveOrUpdate(category);
    }

    @Override
    public void update(CategoryRepr category) {
        if (category.getId() == null) {
            throw new IllegalArgumentException();
        }
        saveOrUpdate(category);
    }

    @TransactionAttribute
    @Override
    public void saveOrUpdate(CategoryRepr category) {
        logger.info("Saving category with id {}" , category.getId());
        categoryRepository.saveOrUpdate(new Category(category.getName()));
    }

    @TransactionAttribute
    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
