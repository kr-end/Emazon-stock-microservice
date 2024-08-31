package com.example.emazonstock.domain.exception;

public class CategoryAlreadyExistError extends RuntimeException {

    public CategoryAlreadyExistError(String message) {

        super(message);

    }

}
