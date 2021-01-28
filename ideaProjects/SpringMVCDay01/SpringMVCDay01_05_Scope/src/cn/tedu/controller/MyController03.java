package cn.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * SpringMVC操作servletContext域
 */
@Controller
@RequestMapping("/my03")
public class MyController03 {

    /**
     * 传统方式使用ServletContext域
     * http://localhost/SpringMVCDay01_05_Scope/my03/test01.action
     */
    @RequestMapping("/test01.action")
    public String test01(HttpServletRequest request){
        ServletContext context = request.getServletContext();
        context.setAttribute("k1","v1");
        context.setAttribute("k2","v2");
        return "my03test01";
    }
}
