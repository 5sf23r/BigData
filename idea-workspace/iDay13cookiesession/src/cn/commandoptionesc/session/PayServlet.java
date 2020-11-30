package cn.commandoptionesc.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //获取session对象
        HttpSession session = request.getSession();
        //获取session域中的属性
        String prod = (String)session.getAttribute("prod");
        if(prod == null){
            response.getWriter().write("您还未选择任何商品");
        }else{
            //向浏览器提示付款信息
            response.getWriter().write("已付款商品「"+prod+"」,价格￥10000000");
        }
    }
}
