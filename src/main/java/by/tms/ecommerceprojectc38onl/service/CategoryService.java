package by.tms.ecommerceprojectc38onl.service;

import by.tms.ecommerceprojectc38onl.dao.CategoryDAO;
import org.springframework.stereotype.Component;


@Component
public class CategoryService {
    private final CategoryDAO categoryDAO;

    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

}
