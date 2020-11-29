package cn.commandoptionesc.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

//用户上次访问页面的时间
//cookie类实现
public class CookieDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //创建time
        Date date = new Date();
        //tomcat8.5版本，在cookie值中不能使用空格，将yyyy-MM-dd hh:mm:ss改为yyyy-MM-dd/hh:mm:ss
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd/hh:mm:ss");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = format.format(date);
        //创建cookie
        //在tomcat8之后，cookie支持中文数据，特殊字符还是不支持，使用URL编码存储，URL解码解析
        //通过URLEncoder.encode(String s ,String enc)进行编码
        Cookie cookie = new Cookie("time", URLEncoder.encode(time,"UTF-8"));
        //发送cookie到浏览器
        response.addCookie(cookie);
        //request.GetCookie将获取的全部cookie一次变成一个cookie对象
        //每一个cookie对象保存各自的cookieName、cookieValue
        //并且将这些对象放入一个cookie数组中保存，方便管理
        Cookie[] cs = request.getCookies();
        Cookie timeC = null;
        //由于初次没有cookie头，所以cs数组为null，遍历会产生空指针异常
        if(cs != null){
            for(Cookie c:cs){
                if("time".equals(c.getName())){
                    timeC = c;
                }
            }
        }
        if(timeC != null){
            //timeC.getValue()获取cookie中的value时间值
            //通过URLDecoder.decode(String s,String enc)进行解码
            response.getWriter().write("您上次访问页面的时间为："+ URLDecoder.decode(timeC.getValue(),"UTF-8"));
        }else{
            response.getWriter().write("您是初次访问本页面");
        }
    }
}
