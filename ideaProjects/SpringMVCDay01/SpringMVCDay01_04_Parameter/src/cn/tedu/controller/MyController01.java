package cn.tedu.controller;

import cn.tedu.domain.User;
import cn.tedu.domain.User2;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 请求参数的获取
 */
@Component
@RequestMapping("/my01")
public class MyController01 {

    /**
     * 获取请求参数 - 获取路径中的数据(RESTFUL风格编程支持)
     * http://localhost/SpringMVCDay01_04_Parameter/my01/zs/bj/test10.action
     */
    @RequestMapping("/{uname}/{uaddr}/test10.action")
    public void test10(@PathVariable("uname") String uname,@PathVariable("uaddr") String uaddr){
        System.out.println(uname);
        System.out.println(uaddr);
    }

    /**
     * 获取请求参数 - 实现文件上传
     *      开发文件上传表单
     *      开发文件上传代码
     * http://localhost/SpringMVCDay01_04_Parameter/my01test09.jsp
     */
    @RequestMapping("/test09.action")
    public void test09(MultipartFile fx) throws IOException {
        fx.transferTo(new File("C://"+fx.getOriginalFilename()));
    }

    /**
     * 获取请求参数 - 日期数据处理
     * http://localhost/SpringMVCDay01_04_Parameter/my01test08.jsp
     */
    @InitBinder
    public void myDateInitBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }
    @RequestMapping("/test08.action")
    public void test08(String username,Date birthday) throws ParseException {
        System.out.println(username);
        System.out.println(birthday);
    }

    /**
     * 获取请求参数 - 中文乱码处理
     *      springmvc内置了乱码解决过滤器，简单配置后可以用来解决请求参数乱码
     *      但这个过滤器只能解决POST提交乱码，对GET提交请求参数乱码无效
     * http://localhost/SpringMVCDay01_04_Parameter/my01test07.jsp
     */
    @RequestMapping("/test07.action")
    public void test07(String username,String addr) throws UnsupportedEncodingException {
        System.out.println(username);
        System.out.println(addr);
    }

    /**
     * 获取请求参数 - 处理多个同名请求参数
     *      如果用String接收，则传入多个值用逗号连接后的字符串
     *      如果用Stirng数组接收，则传入多个值组成的数组
     * http://localhost/SpringMVCDay01_04_Parameter/my01/test06.action?like=zq&like=lq&like=ppq
     */
    @RequestMapping("/test06.action")
    //public void test06(String like){
    public void test06(String [] like){
        //System.out.println(like);
        System.out.println(Arrays.asList(like));
    }

    /**
     * 获取请求参数 - 自动封装数据到bean - 处理复杂类型
     *      可以通过点号设定自定义bean类型中带有复杂类型的数据
     * http://localhost/SpringMVCDay01_04_Parameter/my01/test05.action?uname=zs&uage=19&uaddr=bj&dog.name=wc&dog.age=5
     */
    @RequestMapping("/test05.action")
    public void test05(User2 user2){
        System.out.println(user2);
    }

    /**
     * 获取请求参数 - 自动封装数据到bean
     *      要求请求参数名和bean的属性名对应
     * http://localhost/SpringMVCDay01_04_Parameter/my01/test04.action?uname=zs&uage=19&uaddr=bj
     */
    @RequestMapping("/test04.action")
    public void test04(User user){
        System.out.println(user);
    }

    /**
     * 获取请求参数 - 直接获取 - 方法参数名和请求参数名不一致
     *      可以通过@RequestParam手工指定方法参数到请求参数的映射关系
     * http://localhost/SpringMVCDay01_04_Parameter/my01/test03.action?uname=zs&uage=19
     */
    @RequestMapping("/test03.action")
    public void test03(@RequestParam("uname") String name,@RequestParam("uage") int age){
        System.out.println(name);
        System.out.println(age);
    }

    /**
     * 获取请求参数 - 直接获取
     *      要求方法参数名必须和请求参数名对应
     * http://localhost/SpringMVCDay01_04_Parameter/my01/test02.action?uname=zs&uage=19
     */
    @RequestMapping("/test02.action")
    public void test02(String uname,int uage){
        System.out.println(uname);
        System.out.println(uage);
    }

    /**
     * 获取请求参数 - 通过request对象获取请求参数
     * http://localhost/SpringMVCDay01_04_Parameter/my01/test01.action?uname=zs&uage=19
     */
    @RequestMapping("/test01.action")
    public void test01(HttpServletRequest request){
        String  uname = request.getParameter("uname");
        int uage = Integer.parseInt(request.getParameter("uage"));
        System.out.println(uname);
        System.out.println(uage);
    }
}
