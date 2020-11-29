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
//cookie生命时长、有效路径设置
public class CookieDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = format.format(date);
        //创建cookie
        Cookie cookie = new Cookie("time", URLEncoder.encode(time,"UTF-8"));
        //修改cookie生命时长、有效路径
        //设置cookie生命时长（以秒值为单位
        cookie.setMaxAge(60*60*24);
        //设置路径
        //修改为web应用的虚拟路径
        //如果是缺省web应用，则在request.getContextPath中获取到一个空的返回值
        //这个值不能作为setPath的值，需要在其后加上一个"/"，来表明是当前web应用的路径
        cookie.setPath(request.getContextPath()+"/");
        //发送cookie
        response.addCookie(cookie);
        //获取cookie
        Cookie[] cs = request.getCookies();
        Cookie timeC = null;
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
