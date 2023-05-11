package com.common.exception;

import com.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.awt.event.ItemEvent;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalException {


    /**
     * 请求参数异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public Result HttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error(e.getClass()+e.getMessage());
        return Result.error("请求参数非法！");
    }

    /**
     * 参数校验异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Result methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error(e.getClass()+e.getMessage()+e.getAllErrors());

        return Result.error(e.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField,FieldError::getDefaultMessage)));
    }

    /**
     * 未知异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    public Result unKnowException(Exception e) {
        log.error(e.getClass()+e.getMessage());
        return Result.error("未知异常！");
    }
}
