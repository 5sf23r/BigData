package cn.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * request域的使用
 */
@Controller
@RequestMapping("/my01")
public class MyController01 {

    /**
     * 通过Model将数据存入request域
     *      存入Model中的数据默认就是存入了requset域
     * http://localhost/SpringMVCDay01_05_Scope/my01/test02.action
     */
    @RequestMapping("/test02.action")
    public String test02(Model model){
        model.addAttribute("k1","v1");
        model.addAttribute("k2","v2");
        return "my01test02";
    }

    /**
     * 传统方式使用request域
     * http://localhost/SpringMVCDay01_05_Scope/my01/test01.action
     */
    @RequestMapping("/test01.action")
    public String test01(HttpServletRequest request){
        request.setAttribute("k1","v1");
        request.setAttribute("k2","v2");
        return "my01test01";
    }
}
