package com.hebust.jtc.controller.Utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class exception {
    @ExceptionHandler
    public R doExcetion(Exception e){
        e.printStackTrace();
        return new R("不允许该操作");
    }
}
