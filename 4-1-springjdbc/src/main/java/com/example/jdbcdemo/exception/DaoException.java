package com.example.jdbcdemo.exception;

public class DaoException extends RuntimeException {
    public DaoException(String message) {
        super(message);
    }
}
