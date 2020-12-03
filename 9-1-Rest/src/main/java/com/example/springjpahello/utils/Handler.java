package com.example.springjpahello.utils;

import com.example.springjpahello.exception.ResourceNotFound;

import java.util.Optional;

public class Handler {
    public static void optionalExceptionHandler(Optional<?> optional, String message) {
        optional.orElseThrow(() ->new ResourceNotFound(message));
    }
}
