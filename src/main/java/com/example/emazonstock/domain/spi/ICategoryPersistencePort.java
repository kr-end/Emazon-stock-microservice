package com.example.emazonstock.domain.spi;

import com.example.emazonstock.domain.model.Category;

import java.util.Optional;

public interface ICategoryPersistencePort {

    void save(Category category);

    Optional<Category> findByName(String name);
}
