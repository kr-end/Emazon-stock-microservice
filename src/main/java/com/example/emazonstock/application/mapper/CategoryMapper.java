package com.example.emazonstock.application.mapper;

import com.example.emazonstock.application.dto.request.CategoryRequest;
import com.example.emazonstock.application.dto.response.CategoryResponse;
import com.example.emazonstock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    Category requestToModel(CategoryRequest categoryRequest);

    CategoryResponse modelToResponse(Category category);

    List<CategoryResponse> modelToResponseList(List<Category> categoryList);

}
