package com.example.emazonstock.application.handler;

import com.example.emazonstock.application.dto.request.CategoryRequest;
import com.example.emazonstock.application.dto.response.CategoryResponse;
import com.example.emazonstock.application.mapper.CategoryMapper;
import com.example.emazonstock.domain.api.ICategoryServicePort;
import com.example.emazonstock.domain.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryHandler {

    private final ICategoryServicePort categoryService;
    private final CategoryMapper categoryMapper;

    public void save(CategoryRequest categoryRequest) {

        Category category = categoryMapper.requestToModel(categoryRequest);
        categoryService.saveCategory(category);

    }

    public List<CategoryResponse> findAll(int page, int size, boolean asc){

        List<Category> categoryList = categoryService.getAllCategories(page, size, asc);
        List<CategoryResponse> categoryResponseList = categoryMapper.modelToResponseList(categoryList);

        return categoryResponseList;

    }

}
