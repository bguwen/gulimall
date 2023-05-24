package com.common.exception;


public class MyException extends RuntimeException{

    private final Integer code;
    public MyException(String message,Integer code) {
        super(message);
        this.code= code;
    }

    public Integer getCode() {
        return code;
    }
}
