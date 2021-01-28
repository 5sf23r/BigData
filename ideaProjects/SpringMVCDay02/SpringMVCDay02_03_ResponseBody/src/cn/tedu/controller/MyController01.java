package cn.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/my01")
public class MyController01 {

    /**
     * 向浏览器直接输出数据 - SpringMVC方式 - 中文乱码解决
     *      通过@ResponseBody输出数据时，设定response.setContentType("text/html;charset=utf-8");是无效的
     *      此时只能通过@RequestMapping注解中的produces属性来设置输出的MIME类型
     * http://localhost/SpringMVCDay02_03_ResponseBody/my01/test04.action
     */
    @RequestMapping(value="/test04.action",produces="text/html;charset=utf-8")
    @ResponseBody
    public String test04(HttpServletResponse response){
        //response.setContentType("text/html;charset=utf-8");
        return "hello~my01test03~中国~";
    }

    /**
     * 向浏览器直接输出数据 - SpringMVC方式
     *      通过@ResponseBody注解表明当前控制器方法的返回值要直接输出到响应体中发送给浏览器
     * http://localhost/SpringMVCDay02_03_ResponseBody/my01/test03.action
     */
    @RequestMapping("/test03.action")
    @ResponseBody
    public String test03(){
        return "hello~my01test03~";
    }

    /**
     * 向浏览器直接输出数据 - 传统方式2
     * http://localhost/SpringMVCDay02_03_ResponseBody/my01/test02.action
     */
    @RequestMapping("/test02.action")
    public void tset02(PrintWriter writer){
        writer.write("hello~my01test02~");
    }

    /**
     * 向浏览器直接输出数据 - 传统方式
     * http://localhost/SpringMVCDay02_03_ResponseBody/my01/test01.action
     */
    @RequestMapping("/test01.action")
    public void test01(HttpServletResponse response) throws IOException {
        response.getWriter().write("hello~my01test01~");
    }
}
