package cn.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * SpringMVC操作session域
 */
@Controller
@RequestMapping("/my02")
@SessionAttributes({"kx1","kx2"})
public class MyController02 {
    /**
     * SpringMVC方式操作session域
     *      @SessionAttributes注解可以将Model中存入的指定名称的键值对复制到session域中
     *      但此注解是用在类上的，所以会影响这个类中所有的控制器方法，作用范围比较大，用的时候要小心
     * http://localhost/SpringMVCDay01_05_Scope/my02/test03.action
     */
    @RequestMapping("/test03.action")
    public String test03(Model model){
        model.addAttribute("kx1","v1");
        model.addAttribute("kx2","v2");
        return "my02test03";
    }

    /**
     * 传统方式操作session域
     * http://localhost/SpringMVCDay01_05_Scope/my02/test02.action
     */
    @RequestMapping("/test02.action")
    public String test02(HttpSession session){
        session.setAttribute("k1","v1");
        session.setAttribute("k2","v2");
        return "my02test02";
    }

    /**
     * 传统方式操作session域
     * http://localhost/SpringMVCDay01_05_Scope/my02/test01.action
     */
    @RequestMapping("/test01.action")
    public String test01(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("k1","v1");
        session.setAttribute("k2","v2");
        return "my02test01";
    }
}
