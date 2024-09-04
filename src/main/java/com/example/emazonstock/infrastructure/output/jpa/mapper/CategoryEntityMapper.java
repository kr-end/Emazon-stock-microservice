package com.example.emazonstock.infrastructure.output.jpa.mapper;

import com.example.emazonstock.domain.model.Category;
import com.example.emazonstock.infrastructure.output.jpa.entity.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {

    CategoryEntity modelToCategoryEntity(Category category);
    Category entityToModel(CategoryEntity categoryEntity);
    List<Category> entityToModelList(List<CategoryEntity> categoryEntityList);

}