package com.example.emazonstock.infrastructure.output.jpa.adapter;

import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.domain.spi.ICategoryPersistencePort;
import com.example.emazonstock.infrastructure.output.jpa.entity.CategoryEntity;
import com.example.emazonstock.infrastructure.output.jpa.mapper.CategoryEntityMapper;
import com.example.emazonstock.infrastructure.output.jpa.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistencePort {

    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public void save(Category category) {
        categoryRepository.save(categoryEntityMapper.modelToCategoryEntity(category));
    }

    @Override
    public Optional<Category> findByName(String name) {
        return categoryRepository.findByName(name).map(categoryEntityMapper::entityToModel);
    }

    @Override
    public List<Category> findAllCategories(int page, int size, boolean asc) {

        Sort sort = asc ? Sort.by("name").ascending() : Sort.by("name").descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<CategoryEntity> categoryEntityPage = categoryRepository.findAll(pageable);
        List<Category> categoryList = categoryEntityMapper.entityToModelList(categoryEntityPage.getContent());

        return categoryList;
    }
}
