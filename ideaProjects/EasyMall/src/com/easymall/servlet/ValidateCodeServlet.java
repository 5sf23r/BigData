package com.easymall.servlet;

import com.easymall.utils.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ValidateCodeServlet")
public class ValidateCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //控制浏览器不能使用缓存
        response.setDateHeader("Expires",-1);
        response.setHeader("Cache-control","no-cache");
        //1. 使用工具类，生成一张验证码的图片
        VerifyCode verifyCode = new VerifyCode();
        //生成图片，把图片保存到输出流中，并且调用write方法
        verifyCode.drawImage(response.getOutputStream());
        //2. 获取验证的code
        String code = verifyCode.getCode();
        //3. 把code放入到session中
        request.getSession().setAttribute("valistr",code);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
