package com.example.emazonstock.application.mapper;

import com.example.emazonstock.application.dto.request.CategoryRequest;
import com.example.emazonstock.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    Category requestToModel(CategoryRequest categoryRequest);

}
