package cn.commandoptionesc.response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 控制缓存：
 * 使用缓存
 */
public class ResponseDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //当前缓存3秒钟
        //response.setHeader("Cache-control","max-age=3");
        //当前缓存24小时
        response.setDateHeader("Expires",System.currentTimeMillis()+1000*60*60*24);

        Date date = new Date();
        //String time = date.toLocaleString();
        //response.getWriter().write("time:"+time);
        SimpleDateFormat sdf = (SimpleDateFormat) DateFormat.getDateTimeInstance();
        response.getWriter().write("time:"+sdf.format(date));
    }
}
