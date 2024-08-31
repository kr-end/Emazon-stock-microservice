package com.example.emazonstock.configuration;

import com.example.emazonstock.application.mapper.CategoryMapper;
import com.example.emazonstock.domain.api.ICategoryServicePort;
import com.example.emazonstock.domain.api.usecase.CategoryUseCase;
import com.example.emazonstock.domain.spi.ICategoryPersistencePort;
import com.example.emazonstock.infrastructure.output.jpa.adapter.CategoryJpaAdapter;
import com.example.emazonstock.infrastructure.output.jpa.mapper.CategoryEntityMapper;
import com.example.emazonstock.infrastructure.output.jpa.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CategoryBeanConfiguration {

    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Bean
    public ICategoryPersistencePort categoryPersistencePort() {
        return new CategoryJpaAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public ICategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }
}
