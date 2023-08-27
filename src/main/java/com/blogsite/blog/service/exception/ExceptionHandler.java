package com.blogsite.blog.service.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler
    public Map<String,String> InvalidData(ServiceException ex){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("status", String.valueOf(HttpStatus.BAD_REQUEST));
        errorMap.put("error", ex.getMessage());
        return errorMap;
    }
}
