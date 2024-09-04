package com.example.emazonstock.infrastructure.input.rest.controller;

import com.example.emazonstock.application.dto.request.CategoryRequest;
import com.example.emazonstock.application.dto.response.CategoryResponse;
import com.example.emazonstock.application.handler.CategoryHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryHandler categoryHandler;

    @PostMapping
    public ResponseEntity<Void> saveCategory(@Valid @RequestBody CategoryRequest categoryRequest) {

        categoryHandler.save(categoryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories(@RequestParam int page, @RequestParam int size, @RequestParam boolean asc) {

        return ResponseEntity.ok(categoryHandler.findAll(page, size, asc));

    }
}