package cn.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my01")
public class MyController01 {

    /**
     * 当前控制器类内部的异常处理机制 - 只对当前控制器类内部的控制方法有效
     */
    @ExceptionHandler
    public String My01ExceptionHander(Exception e){
        System.out.println("#####发生异常#####"+e.getMessage());
        return "my01err";
    }

    /**
     * 异常处理
     * http://localhost/SpringMVCDay02_02_Exception/my01/test01.action
     */
    @RequestMapping("/test01.action")
    public void test01(){
        int i = 1/0;
    }
}
