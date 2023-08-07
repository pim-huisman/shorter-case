package com.klm.cases.df;


import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BasicExceptionHandler {

    @ExceptionHandler(value = {FeignException.NotFound.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public HttpStatus resourceNotFoundException() {
        return HttpStatus.NOT_FOUND;
    }
}
