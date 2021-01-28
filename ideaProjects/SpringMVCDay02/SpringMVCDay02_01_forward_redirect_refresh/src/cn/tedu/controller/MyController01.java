package cn.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/my01")
public class MyController01 {

    /**
     * 请求转发 - springMVC方式
     *  http://localhost/SpringMVCDay02_01_forward_redirect_refresh/my01/test02.action
     */
    @RequestMapping("/test02.action")
    public String test02(){
        return "forward:/index.jsp";
    }

    /**
     * 请求转发 - 传统方式
     * http://localhost/SpringMVCDay02_01_forward_redirect_refresh/my01/test01.action
     */
    @RequestMapping("/test01.action")
    public void test01(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
