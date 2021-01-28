package cn.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/my02")
public class MyController02 {
    /**
     * http://localhost/SpringMVCDay02_02_Exception/my02/test03.action
     */
    @RequestMapping("/test03.action")
    public void test03() throws IOException {
        throw new IOException();
    }
    /**
     * http://localhost/SpringMVCDay02_02_Exception/my02/test02.action
     */
    @RequestMapping("/test02.action")
    public void test02(){
        String str = null;
        str.toUpperCase();
    }
    /**
     * http://localhost/SpringMVCDay02_02_Exception/my02/test01.action
     */
    @RequestMapping("/test01.action")
    public void test01(){
        int i = 1/0;
    }
}
