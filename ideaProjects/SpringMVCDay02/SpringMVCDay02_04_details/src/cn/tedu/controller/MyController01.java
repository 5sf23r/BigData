package cn.tedu.controller;

import cn.tedu.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;

/**
 * SpringMVC控制器方法可以接受的参数
 */
@Controller
@RequestMapping("/my01")
public class MyController01 {
    /**
     * http://localhost/SpringMVCDay02_04_details/my01/test01.action
     * http://localhost/SpringMVCDay02_04_details/my01/test01.action?name=zs&age=91&addr=bj
     */
    @RequestMapping("/test01.action")
    public void test01(
            //HttpServletRequest request,
            //HttpServletResponse respons,
            //HttpSession session,
            //--------WebRequest webRequest//request和session的合体
            //InputStream in,//request.getInputStream()
            //OutputStream out,//response.getOutputStream()
            //Reader reader,//request.getReader()
            //Writer writer,//response.getWriter()
            //String name, //获取请求参数
            //@RequestParam("uaddr") String addr, //获取请求参数，请求参数名和方法参数名不一致时
            //@PathVariable("ucountry") String country,//获取路径中的请求参数
            //--------@CookieValue("JSESSIONID") String cv,//获取cookie值
            //--------@RequestHeader("Host") String hv,//获取请求头的值
            //Model model, //Model模型对象
            //--------Map map,//Map作为模型对象
            //--------ModelMap modelMap, //ModelMap作为模型对象，ModelMap = Model+Map
            //User user //直接将请求参数封装到bean中
            //MultipartFile fx,//实现文件上传
            //========Errors errs, //实现数据校验
            //========BindingResult bresult //实现数据校验
    ){
        //model.addAttribute("k1","v1");
        //model.addAttribute("k2","v2");
        //model.addAttribute("k3","v3");

        //map.put("k1","v1");
        //map.put("k2","v2");
        //map.put("k3","v3");

        //modelMap.addAttribute("k1","v1");
        //modelMap.addAttribute("k2","v2");
        //modelMap.put("k3","v3");
        //return "my01test01";

        //System.out.println(user);
    }
}
