package com.example.Banking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = IdNotFoundException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse specialResponse(IdNotFoundException e) {
        ErrorResponse ex = new ErrorResponse();
        ex.setErrorCode(HttpStatus.NO_CONTENT.value());
        ex.setMessage(e.getMsg());
        return ex;
    }

}

