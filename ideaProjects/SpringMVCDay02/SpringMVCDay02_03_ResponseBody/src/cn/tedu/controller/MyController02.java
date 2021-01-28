package cn.tedu.controller;

import cn.tedu.domain.Dog;
import cn.tedu.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Controller
@RequestMapping("/my02")
public class MyController02 {

    /**
     * 将对象转为json发送给客户端 - @ResponseBody
     *      当在@ResponseBody标注的控制器方法中返回一个对象时，SpringMVC会先将对象转为json格式后输出给客户端
     * http://localhost/SpringMVCDay02_03_ResponseBody/my02/test02.action
     */
    @RequestMapping("/test02.action")
    @ResponseBody
    public User test02(){
        User user = new User(9,"zs", Arrays.asList("bj","sh","gz"),new Dog("wc",5));
        return user;
    }

    /**
     * 将对象转为json发送给客户端 - 手工方式
     * http://localhost/SpringMVCDay02_03_ResponseBody/my02/test01.action
     */
    @RequestMapping("/test01.action")
    public void test01(HttpServletResponse response) throws IOException {
        User user = new User(9,"zs", Arrays.asList("bj","sh","gz"),new Dog("wc",5));
        StringBuilder sb = new StringBuilder();
        for (String addr : user.getAddrs()){
            sb.append("'"+addr+"',");
        }
        String addr = sb.subSequence(0,sb.length()-1).toString();
        String json = "{'id':"+user.getId()+",'name':'"+user.getName()+"','addrs':["+addr+"],'dog':{'name':'"+user.getDog().getName()+"','age':"+user.getDog().getAge()+"}}";
        response.getWriter().write(json);
    }
}
