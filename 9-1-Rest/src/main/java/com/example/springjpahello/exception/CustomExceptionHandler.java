package com.example.springjpahello.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class,
            ConstraintViolationException.class,
            org.hibernate.exception.ConstraintViolationException.class,
            DataIntegrityViolationException.class,
            UnsatisfiedServletRequestParameterException.class,
            MethodArgumentTypeMismatchException.class})
    public final ResponseEntity<?> handleValidationException(Exception ex) {
        String message = null;
        Map<String, Object> errorMap = new HashMap<>();
        if (ex instanceof MethodArgumentNotValidException) {
            BindingResult result = ((MethodArgumentNotValidException) ex).getBindingResult();
            result.getFieldErrors().forEach((fieldError) -> {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            });
            result.getGlobalErrors().forEach((fieldError) -> {
                errorMap.put(fieldError.getObjectName(), fieldError.getDefaultMessage());
            });
            message = "validation failed. Please provide correct input values.";
        }

        /*else if (ex instanceof org.hibernate.exception.ConstraintViolationException) {
            org.hibernate.exception.ConstraintViolationException constraintViolationException = ((org.hibernate.exception.ConstraintViolationException) ex);
            errorMap.put(constraintViolationException.getErrorCode() + ":" + constraintViolationException.getConstraintName(), constraintViolationException.getLocalizedMessage());
            message = " ConstraintViolationException database validation failed. Please  try again.";
        }
        */else if (ex instanceof DataIntegrityViolationException) {
            errorMap.put("database Constraint Violation Exception: ", ((DataIntegrityViolationException) ex).getLocalizedMessage());
            message = "database validation failed. Please  try again.";
        } else if (ex instanceof UnsatisfiedServletRequestParameterException) {
            UnsatisfiedServletRequestParameterException exception = (UnsatisfiedServletRequestParameterException) ex;
            errorMap.putAll(exception.getActualParams());
            System.out.println(exception.getActualParams()+" getParamConditions :"+exception.getParamConditions()+"  "+exception.getParamConditionGroups());
            message = ex.getMessage();
        }
        else if (ex instanceof MethodArgumentTypeMismatchException) {
            MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException) ex;

            errorMap.put(exception.getErrorCode(), exception.getLocalizedMessage());
            message = "type mismatch for "+exception.getName();
        }
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Timestamp(System.currentTimeMillis()), message, errorMap);
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({
            NullPointerException.class
    })
    public final ResponseEntity<?> handleResourceException(NullPointerException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Timestamp(System.currentTimeMillis()), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceNotFound.class)
    public final ResponseEntity<?> handleNotFoundException(ResourceNotFound ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Timestamp(System.currentTimeMillis()), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<?> handleAllRuntimeException(RuntimeException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Timestamp(System.currentTimeMillis()), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<?> handleAllException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Timestamp(System.currentTimeMillis()), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}