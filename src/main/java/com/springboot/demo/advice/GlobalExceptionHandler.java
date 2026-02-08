package com.springboot.demo.advice;

import com.springboot.demo.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleInvalidArgException(StudentNotFoundException ex) {
        Map<String, String> errorMap = new LinkedHashMap<>();
        errorMap.put("status", "404");
        errorMap.put("Error:", ex.getMessage());
        return errorMap;
    }
}
