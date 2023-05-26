package com.common.exception;


import com.common.utils.HttpStatus;

public class MyException extends RuntimeException {

    private final Integer code;

    public MyException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public MyException(String message) {
        super(message);
        this.code = HttpStatus.ERROR;
    }

    public Integer getCode() {
        return code;
    }
}
