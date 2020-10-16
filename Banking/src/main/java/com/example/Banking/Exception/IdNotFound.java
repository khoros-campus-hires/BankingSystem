package com.example.Banking.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Component
public class IdNotFound extends Exception {

    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;

    public IdNotFound() {

    }

    public IdNotFound(String err) {
        this.msg = err;
    }

    public IdNotFound(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }



    /*
    public void throwException() throws IdNotFound{
        IdNotFound e = new IdNotFound();
        e.setCode(500);
        e.setMsg("UserId not found");
        throw e;
    }*/
}
