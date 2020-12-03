package com.example.springjpahello.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    Timestamp timestamp;
    String message;
    Object details;
}
