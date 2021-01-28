package cn.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/my03")
public class MyController03 {
    /**
     * 定时刷新 - 传统方式
     * http://localhost/SpringMVCDay02_01_forward_redirect_refresh/my03/test01.action
     */
    @RequestMapping("/test01.action")
    public void test01(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("注册成功，3秒后回到主页..");
        response.setHeader("refresh","3;url="+request.getContextPath()+"/index.jsp");
    }
}
