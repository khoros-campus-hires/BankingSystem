package com.example.Banking.exception;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Component

public class IdNotFound extends Exception {

    private static final long serialVersionUID = 1L;

    private String msg;
    public IdNotFound() { }

    public IdNotFound(String err) {
        this.msg = err;
    }
}
