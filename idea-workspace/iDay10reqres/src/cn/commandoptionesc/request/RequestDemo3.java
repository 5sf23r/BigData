package cn.commandoptionesc.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
/**
 * 获取请求参数
 */
public class RequestDemo3 extends HttpServlet {
    // getParameter(String name) --- String 通过name获得值
    // getParameterValues(String name) --- String[]通过name获得多值 checkbox
    // getParameterMap() --- Map<String,String[]> key:name value:多值  将查询的参数保存在一个Map中
    // getParameterNames() --- Enumeration<String> 获得所有name
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //utf-8中有中文，所以需要将服务器的字符集修改为utf-8
        //通知服务器使用utf-8字符集解码数据
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        //byte[] bytes = username.getBytes("iso8859-1");
        //username = new String(bytes,"utf-8");
        System.out.println("username:"+username);
        //多个同名参数获取需要使用getParameterValues来获取
        String[] like = request.getParameterValues("like");
        System.out.println("like:"+ Arrays.toString(like));
        //获取全部请求参数名称
        Enumeration<String> pNames = request.getParameterNames();
        while(pNames.hasMoreElements()){
            //遍历全部的参数名
            String name = (String)pNames.nextElement();
            //根据参数名获取参数值
            String[] value = request.getParameterValues(name);
            //根据参数名获取参数值，由于获取的参数值中可能会有多个，所以利用getParameterValues获取所有参数值，这样所有参数值会放入一个数组当中
            System.out.println("≤name:"+name+">>>>value:"+Arrays.toString(value));
        }
        //将用户的全部参数名以及参数值放入一个map中
        @SuppressWarnings({"unused","unckecked"})
        Map<String,String[]> map = request.getParameterMap();
        for(Entry<String,String[]> entry:map.entrySet()){
            String key = entry.getKey();
            String [] value = entry.getValue();
            System.out.println(key+":"+Arrays.toString(value));
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
