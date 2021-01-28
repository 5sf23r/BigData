package cn.tedu.controller;

import cn.tedu.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

/**
 * SpringMVC控制器方法可以返回的返回值
 */
@Controller
@RequestMapping("/my02")
public class MyController02 {

    /**
     * http://localhost/SpringMVCDay02_04_details/my02/test06.action
     * 其他情况下，无论返回什么，返回值都会被加入模型中
     */
    @RequestMapping("/test06.action")
    public User test06(){
        User user = new User("zs",19,"bj");
        return user;
    }

    /**
     * http://localhost/SpringMVCDay02_04_details/my02/test05.action
     * @ResponseBody 注解 修饰的控制器方法 无论返回什么 都发送给浏览器
     */
    @ResponseBody
    @RequestMapping("/test05.action")
    public String test05(){
        return "test05";
    }

    /**
     * http://localhost/SpringMVCDay02_04_details/my02/test04.action
     * void 将当前控制器方法路径去除后缀后作为视图名返回
     */
    @RequestMapping("/test04.action")
    public void test04(){

    }

    /**
     * http://localhost/SpringMVCDay02_04_details/my02/test03.action
     * String 返回的字符串作为视图名称使用
     */
    @RequestMapping("/test03.action")
    public String test03(){
        return "test03";
    }

    /**
     * http://localhost/SpringMVCDay02_04_details/my02/test02.action
     * View 视图信息对象
     */
    @RequestMapping("/test02.action")
    public View test02(Model model){
        return null;
    }

    /**
     * http://localhost/SpringMVCDay02_04_details/my02/test01.action
     * ModelAndView 封装了视图和模型信息的对象
     */
    @RequestMapping("/test01.action")
    public ModelAndView test01(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("k1","v1");
        mav.addObject("k2","v2");
        mav.setViewName("test01");
        return mav;
    }
}
