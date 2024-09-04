package com.example.emazonstock.domain.exception;

public class NoDataFoundError extends RuntimeException {
    public NoDataFoundError(String message) {
        super(message);
    }
}
