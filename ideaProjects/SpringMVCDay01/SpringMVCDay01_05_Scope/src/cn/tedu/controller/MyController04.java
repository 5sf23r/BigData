package cn.tedu.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 	@ModelAttribute的使用
 * 	    可以用在普通方法上
 *      可以用在控制器方法的参数上
 */
@Controller
@RequestMapping("/my04")
public class MyController04 {

    @ModelAttribute("k1")
    public String myfunc01(){
        System.out.println("myfunc01..");
        return "abc";
    }

    /**
     * @ModelAttribute 用法2
     *      用在控制器方法的参数上，则在控制器方法执行时，会自动从Model中获取指定键的值赋值给该参数
     * http://localhost/SpringMVCDay01_05_Scope/my04/test02.action
     */
    @RequestMapping("/test02.action")
    public void test02(@ModelAttribute("k1") String str){
        System.out.println(str);
    }

    /**
     * @ModelAttribute 用法1
     *      用在普通方法上，则此方法会在这个控制器类的所有控制器方法执行之前执行
     *      将返回值按照指定键预存入Model中，控制器方法得到的Model中提前就有了这个键值对
     * http://localhost/SpringMVCDay01_05_Scope/my04/test01.action
     */
    @RequestMapping("/test01.action")
    public void test01(Model model){
        Map<String,Object> map = model.asMap();
        System.out.println(map);
    }
}
