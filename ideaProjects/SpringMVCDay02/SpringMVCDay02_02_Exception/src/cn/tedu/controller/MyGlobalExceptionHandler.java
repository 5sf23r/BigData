package cn.tedu.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局错误处理器
 */
//@ControllerAdvice
public class MyGlobalExceptionHandler {
    @ExceptionHandler
    public String myExceptionHandler(Exception e){
        System.out.println("#####全局发生异常#####"+e.getMessage());
        return "err";
    }
}
