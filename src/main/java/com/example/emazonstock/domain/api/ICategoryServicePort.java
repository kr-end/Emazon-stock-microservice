package com.example.emazonstock.domain.api;

import com.example.emazonstock.domain.model.Category;

import java.util.List;

public interface ICategoryServicePort {

    void saveCategory(Category category);

    List<Category> getAllCategories(int page, int size, boolean asc);

}