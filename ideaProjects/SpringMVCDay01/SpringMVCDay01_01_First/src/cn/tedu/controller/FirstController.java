package cn.tedu.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//实现Controller接口
public class FirstController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("hello springmvc~");
        //1. 创建ModelAndView
        ModelAndView mav = new ModelAndView();
        //2. 封装数据
        mav.addObject("k1","v1");
        mav.addObject("k2","v2");
        mav.addObject("k3","v3");
        //3. 封装视图
        mav.setViewName("first");
        //4. 返回ModelAndView
        return mav;
    }
}
