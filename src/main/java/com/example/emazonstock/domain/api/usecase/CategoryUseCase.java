package com.example.emazonstock.domain.api.usecase;

import com.example.emazonstock.domain.api.ICategoryServicePort;
import com.example.emazonstock.domain.exception.CategoryAlreadyExistError;
import com.example.emazonstock.domain.exception.NoDataFoundError;
import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.spi.ICategoryPersistencePort;

import java.util.List;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(Category category) {

        if (categoryPersistencePort.findByName(category.getName()).isPresent()) {
            throw new CategoryAlreadyExistError("Category already exist");
        }

        categoryPersistencePort.save(category);
    }

    @Override
    public List<Category> getAllCategories(int page, int size, boolean asc) {

        List<Category> categoryList = categoryPersistencePort.findAllCategories(page, size, asc);

        if(categoryList.isEmpty()) {
            throw new NoDataFoundError("Categories not found");
        }

        return categoryList;
    }
}
